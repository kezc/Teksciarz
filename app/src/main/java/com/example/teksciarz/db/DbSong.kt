package com.example.teksciarz.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.teksciarz.data.Song

@Entity(tableName = "songs")
data class DbSong(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val artist: String,
    val title: String,
    val lyrics: String,
    val imageUrl: String?
) {
    fun toSong() = Song(
        title, artist, imageUrl,
        lyrics = lyrics
    )
}