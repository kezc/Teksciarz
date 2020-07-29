package com.example.teksciarz.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teksciarz.SongRepository
import com.example.teksciarz.network.GeniusService
import kotlinx.coroutines.launch

class SpotifyLyricsViewModel : ViewModel() {
    fun search() = viewModelScope.launch {
        val rep = SongRepository(GeniusService.create())
        val obj = rep.getSongByArtistAndTitle("Kanye West", "Closed on Sunday")
        Log.d("SpotifyLyricsViewModel", obj.toString())
    }
}