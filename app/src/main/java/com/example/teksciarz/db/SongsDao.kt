package com.example.teksciarz.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface SongsDao {
    @Query("SELECT * FROM songs WHERE :artist == artist AND :title == title LIMIT 1")
    suspend fun getSongByArtistAndTitle(artist: String, title: String): DbSong?

    @Insert
    suspend fun insertSong(
        dbSong: DbSong
    )
}
