package com.example.teksciarz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.teksciarz.viewmodels.SpotifyLyricsViewModel

class SpotifyLyricsFragment : Fragment() {
    val viewModel : SpotifyLyricsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_spotify_lyrics, container, false)
        viewModel.search()

        return view
    }


}