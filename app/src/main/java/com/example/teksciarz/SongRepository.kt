package com.example.teksciarz

import com.example.teksciarz.data.GeniusSong
import com.example.teksciarz.data.Song
import com.example.teksciarz.network.GeniusService
import com.example.teksciarz.network.getLyrics
import com.example.teksciarz.network.getPage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SongRepository(private val geniusService: GeniusService) {
    suspend fun getSongByArtistAndTitle(artist: String, title: String): Song? {
        val song = getSongsList(artist, title).firstOrNull()
        return song?.let { it.toSong(getSongLyrics(it)) }
    }

    private suspend fun getSongLyrics(song: GeniusSong) = withContext(Dispatchers.IO) {
        val page = getPage(song.url)
        return@withContext getLyrics(page)
    }

    suspend fun getSongsList(artist: String, title: String) = withContext(Dispatchers.IO) {
        val list = geniusService.searchSong("$artist $title").response.hits
        return@withContext withContext(Dispatchers.Main) {
            list.map { hit ->
                hit.song
            }
        }
    }
}