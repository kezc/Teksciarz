package com.example.teksciarz.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teksciarz.SongRepository
import com.example.teksciarz.data.Song
import com.example.teksciarz.network.GeniusService
import com.spotify.android.appremote.api.SpotifyAppRemote
import com.spotify.protocol.types.Track
import kotlinx.coroutines.launch

class SpotifyLyricsViewModel : ViewModel() {
    private val _currentSong = MutableLiveData<Song?>()
    val currentSong: LiveData<Song?>
        get() = _currentSong

    private val rep = SongRepository(GeniusService.create())
    private var recentSongArtist = ""
    private var recentSongTitle = ""

    var spotifyAppRemote: SpotifyAppRemote? = null

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
                    Log.d(
                        "SpotifyLyricsViewModel",
                        "$title by $artist"
                    )
                    viewModelScope.launch {
                        val song = rep.getSongByArtistAndTitle(artist, title)
                        _currentSong.value = song
                    }
                }
            }
    }

    fun disconnectFromSpotify() =
        spotifyAppRemote?.let {
            SpotifyAppRemote.disconnect(it)
        }

}