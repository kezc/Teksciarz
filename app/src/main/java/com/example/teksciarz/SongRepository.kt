package com.example.teksciarz

import com.example.teksciarz.data.GeniusHit
import com.example.teksciarz.data.GeniusSong
import com.example.teksciarz.data.Song
import com.example.teksciarz.db.DbSong
import com.example.teksciarz.db.SongsDao
import com.example.teksciarz.network.GeniusService
import com.example.teksciarz.network.getLyrics
import com.example.teksciarz.network.getPage
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class SongRepository(private val geniusService: GeniusService, private val database: SongsDao) {


    @ExperimentalCoroutinesApi
    @FlowPreview
    suspend fun getSongByArtistAndTitleWithMultipleRequests(artist: String, title: String) =
        (1..5).asFlow().flatMapMerge(5) {
            flow {
                emit(getSongByArtistAndTitle(artist, title))
            }
        }
            .filterNotNull()
            .filter { song ->
                !song.lyrics.isNullOrBlank()
            }.take(1)
            .flowOn(Dispatchers.IO)


    private suspend fun getSongByArtistAndTitle(artist: String, title: String): Song? =
        withContext(Dispatchers.IO) {
            val defSongFromGenius = async {
                getSong(artist, title)
            }

            val defSongFromDb = async {
                database.getSongByArtistAndTitle(artist, title)?.toSong()
            }

            defSongFromDb.await()?.let {
                defSongFromGenius.cancel()
                return@withContext it
            }

            val songFromGenius = defSongFromGenius.await()
            insertSongIfHasLyrics(songFromGenius)

            return@withContext songFromGenius
        }

    //Is this good place for catching exception?
    private suspend fun getSong(
        artist: String,
        title: String
    ): Song? {
        val geniusSong = getSongsList(artist, title).firstOrNull()
        val lyrics = geniusSong?.let { getLyrics(it) }
        return geniusSong?.toSong(artist, title, lyrics)
    }

    private fun CoroutineScope.insertSongIfHasLyrics(
        song: Song?
    ) =
        launch {
            if (song != null && !song.lyrics.isNullOrBlank()) {
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


    private suspend fun getLyrics(song: GeniusSong): String {
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