package com.example.teksciarz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.teksciarz.viewmodels.SpotifyLyricsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_spotify_lyrics.*

class SpotifyLyricsFragment : Fragment() {
    private val viewModel: SpotifyLyricsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_spotify_lyrics, container, false)

        viewModel.currentSong.observe(viewLifecycleOwner, Observer { song ->
            if (song != null) {
                title.text = song.title
                artist.text = song.artist
                if (!song.lyrics.isNullOrBlank()) {
                    lyrics.text = song.lyrics
                } else {
                    lyrics.text = "Nie moglem znalezc tekstu"
                }
                Glide.with(view).load(song.imageUrl).into(cover)
            } else {
                Snackbar.make(
                    view,
                    "nie znalazlem takiej piosenki, przepraszam :(",
                    Snackbar.LENGTH_LONG
                )
            }
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                loadingLayout.visibility = View.VISIBLE
                mainLayout.visibility = View.INVISIBLE
                loadingDescription.text = it
            } else {
                loadingLayout.visibility = View.INVISIBLE
                mainLayout.visibility = View.VISIBLE
            }
        })

        return view
    }


}