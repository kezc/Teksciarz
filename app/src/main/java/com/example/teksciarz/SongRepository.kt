package com.example.teksciarz

import com.example.teksciarz.data.GeniusHit
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
        return song?.let { it.toSong(artist, title, getSongLyrics(it)) }
    }

    private suspend fun getSongLyrics(song: GeniusSong): String {
        val page = getPage(song.url)
        return getLyrics(page)
    }

    private suspend fun getSongsList(artist: String, title: String): List<GeniusSong> {
        val list = geniusService.searchSong("$artist $title").response.hits
        return list.toGeniusSongsList()
    }

    private suspend fun List<GeniusHit>.toGeniusSongsList() = withContext(Dispatchers.Main) {
        this@toGeniusSongsList.map { hit ->
            hit.song
        }
    }
}