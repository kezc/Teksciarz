package com.example.teksciarz.data

import com.google.gson.annotations.SerializedName

data class GeniusSong(
    @SerializedName("full_title")
    val fullTitle: String,

    @SerializedName("header_image_thumbnail_url")
    val headerImageThumbnailUrl: String,

    @SerializedName("header_image_url")
    val headerImageUrl: String,

    val id: Int,

    val url: String
) {
    fun toSong(lyrics: String): Song {
        return Song(
            fullTitle,
            headerImageThumbnailUrl,
            headerImageUrl,
            id,
            url, lyrics
        )
    }
}