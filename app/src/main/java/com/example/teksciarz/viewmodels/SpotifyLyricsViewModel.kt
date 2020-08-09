package com.example.teksciarz.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.teksciarz.SongRepository
import com.example.teksciarz.data.Song
import com.example.teksciarz.network.GeniusService
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.protocol.types.Track
import kotlinx.coroutines.launch
import java.io.IOException

private const val TAG = "SpotifyLyricsViewModel"
private const val CLIENT_ID = "a7dc1dd3f7e24e4e9b7fd4a7b7ed93bd"
private const val REDIRECT_URI = "com.example.teksciarz://callback"

class SpotifyLyricsViewModel(application: Application) : AndroidViewModel(application) {

    private val _currentSong = MutableLiveData<Song>()
    val currentSong: LiveData<Song>
        get() = _currentSong

    private val _loading = MutableLiveData<String?>()
    val loading: LiveData<String?>
        get() = _loading


    private val rep = SongRepository(GeniusService.create()) //TODO Move to constructor
    private var recentSongArtist = ""
    private var recentSongTitle = ""

    var spotifyAppRemote: SpotifyAppRemote? = null

    init {
        connectToSpotify()
    }

    override fun onCleared() {
        super.onCleared()
        disconnectFromSpotify()
    }

    private fun connectToSpotify() {
        _loading.value = "Connecting to Spotify"

        val connectionParams = ConnectionParams.Builder(CLIENT_ID)
            .setRedirectUri(REDIRECT_URI)
            .showAuthView(true)
            .build()

        SpotifyAppRemote.connect(
            getApplication(),
            connectionParams,
            object : Connector.ConnectionListener {
                override fun onFailure(throwable: Throwable?) {
                    Log.e(TAG, throwable!!.message, throwable)
                    _loading.value = null
                }

                override fun onConnected(spotifyAppRemote: SpotifyAppRemote) {
                    Log.d(TAG, "Connected to Spotify!")
                    onConnectedToSpotify(spotifyAppRemote)
                    _loading.value = null
                }
            })
    }

    fun onConnectedToSpotify(spotifyAppRemote: SpotifyAppRemote) {
        this.spotifyAppRemote = spotifyAppRemote

        spotifyAppRemote.playerApi
            .subscribeToPlayerState()
            .setEventCallback { playerState ->
                val track: Track? = playerState.track
                if (track != null) {
                    val title = track.name.toString()
                    val artist = track.artist.name
                    if (title == recentSongTitle && recentSongArtist == artist) return@setEventCallback
                    recentSongArtist = artist
                    recentSongTitle = title
                    _loading.value = "Loading $recentSongTitle by $recentSongArtist"
                    Log.d(TAG, track.imageUri.raw.toString())
                    viewModelScope.launch {
                        try {
                            val song = rep.getSongByArtistAndTitle(artist, title)
                            if (song != null) {
                                _currentSong.value = song
                            } else {
                                // could be await instead of callback but doesnt work >.<
                                spotifyAppRemote.imagesApi.getImage(track.imageUri)
                                    .setResultCallback { image ->
                                        _currentSong.value =
                                            Song(title, artist, bitmapImage = image)
                                    }

                            }

                            Log.d(TAG, song.toString())
                        } catch (e: IOException) {
                            Log.d(TAG, "Network exception")
                        } finally {
                            _loading.value = null
                        }
                    }
                }
            }
    }

    private fun disconnectFromSpotify() {
        Log.d(TAG, "Disconnecting from Spotify")
        spotifyAppRemote?.let {
            SpotifyAppRemote.disconnect(it)
        }
    }

}