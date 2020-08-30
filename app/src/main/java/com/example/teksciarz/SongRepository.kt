package com.example.teksciarz

import com.example.teksciarz.data.GeniusHit
import com.example.teksciarz.data.GeniusSong
import com.example.teksciarz.data.Song
import com.example.teksciarz.db.DbSong
import com.example.teksciarz.db.SongsDao
import com.example.teksciarz.network.GeniusService
import com.example.teksciarz.network.getLyrics
import com.example.teksciarz.network.getPage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SongRepository(private val geniusService: GeniusService, private val database: SongsDao) {

    suspend fun getSongByArtistAndTitle(artist: String, title: String): Song? =
        withContext(Dispatchers.IO) {
            val defSongFromGenius = async {
                val geniusSong = getSongsList(artist, title).firstOrNull()
                val lyrics = geniusSong?.let { getSongLyrics(it) }
                geniusSong?.toSong(artist, title, lyrics)
            }

            val defSongFromDb = async {
                database.getSongByArtistAndTitle(artist, title)?.toSong()
            }

            defSongFromDb.await()?.let {
                defSongFromGenius.cancel()
                return@withContext it
            }

            val songFromGenius = defSongFromGenius.await()
            launch {
                songFromGenius?.let { song ->
                    if (!song.lyrics.isNullOrBlank()) {
                        database.insertSong(
                            DbSong(
                                artist = song.artist,
                                title = song.title,
                                lyrics = song.lyrics,
                                imageUrl = song.imageUrl
                            )
                        )
                    }
                }
            }
            return@withContext songFromGenius
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