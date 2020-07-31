package com.example.teksciarz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.teksciarz.viewmodels.SpotifyLyricsViewModel
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote
import kotlinx.android.synthetic.main.fragment_spotify_lyrics.*

private const val CLIENT_ID = "a7dc1dd3f7e24e4e9b7fd4a7b7ed93bd"
const val REDIRECT_URI = "com.example.teksciarz://callback"

class SpotifyLyricsFragment : Fragment() {
    val viewModel: SpotifyLyricsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_spotify_lyrics, container, false)

        viewModel.currentSong.observe(viewLifecycleOwner, Observer { song ->
            if (song != null) {
                songInfo.text = song.toString()
            } else {
                songInfo.text = "nie znalazlem takiej piosenki, przepraszam :("
            }
        })
        return view
    }

    override fun onResume() {
        super.onResume()

        connectToSpotify()
    }

    private fun connectToSpotify() {
        val connectionParams = ConnectionParams.Builder(CLIENT_ID)
            .setRedirectUri(REDIRECT_URI)
            .showAuthView(true)
            .build()

        SpotifyAppRemote.connect(
            requireContext(),
            connectionParams,
            object : Connector.ConnectionListener {
                override fun onFailure(throwable: Throwable?) {
                    Log.e("SpotifyLyricsFragment", throwable!!.message, throwable);
                }

                override fun onConnected(spotifyAppRemote: SpotifyAppRemote) {
                    Log.d("SpotifyLyricsFragment", "Connected! Yay!");
                    viewModel.onConnectedToSpotify(spotifyAppRemote)
                }
            })
    }


    override fun onStop() {
        super.onStop()
        Log.d("SpotifyLyricsFragment", "On stop")
        viewModel.disconnectFromSpotify()
    }

}