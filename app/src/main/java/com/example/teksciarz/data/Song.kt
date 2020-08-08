package com.example.teksciarz.data

data class Song(
    val title: String,
    val artist: String,
    var imageUrl: String? = null,
    val imageThumbnailUrl: String? = null,
    val id: Int? = null,
    val url: String? = null,
    val lyrics: String? = null
)