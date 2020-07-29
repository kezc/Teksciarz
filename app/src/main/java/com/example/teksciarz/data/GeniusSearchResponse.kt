package com.example.teksciarz.data

import com.google.gson.annotations.SerializedName

data class GeniusSearchData (
    val response: GeniusSearchResponse
)

data class GeniusSearchResponse(
    val hits: List<GeniusHit>
)

data class GeniusHit(
    val type: String,
    @SerializedName("result")
    val song: GeniusSong
)