package com.example.teksciarz.data

import com.google.gson.annotations.SerializedName

data class Song(
    val fullTitle: String,
    val headerImageThumbnailUrl: String,
    val headerImageUrl: String,
    val id: Int,
    val url: String,
    val lyrics: String
)