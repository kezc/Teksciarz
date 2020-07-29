package com.example.teksciarz.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teksciarz.network.GeniusService
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SpotifyLyricsViewModel : ViewModel() {
    fun search() = viewModelScope.launch {
        val obj = GeniusService.create().searchSong("Kendrick")
        Log.d("SpotifyLyricsViewModel", obj.toString())
    }
}