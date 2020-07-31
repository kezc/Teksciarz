package com.example.teksciarz.data

data class Song(
    val title: String,
    val artist: String,
    val imageUrl: String,
    val imageThumbnailUrl: String?,
    val id: Int,
    val url: String,
    val lyrics: String?
)