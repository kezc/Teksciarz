package com.example.teksciarz

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SongRepository {
    suspend fun getSongLyrics(artist: String, title: String): String {
        return ""
    }

//    suspend fun getSongsList(artist: String, title: String) = TODO()
}