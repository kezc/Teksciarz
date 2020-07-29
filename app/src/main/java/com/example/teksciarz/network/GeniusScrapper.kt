package com.example.teksciarz.network

import org.jsoup.Jsoup
import org.jsoup.nodes.Document


//https://github.com/johnwmillr/LyricsGenius/blob/30a39f1a87ff9a538c78af11736d5c560381e806/lyricsgenius/api.py#L241

fun getPage(url: String): Document {
    val document = Jsoup.connect(url).get()
    document.select("br").append("\\n")
    return document
}

fun getLyrics(page: Document): String {
    val oldDiv = page.select("div.lyrics")
    val newDiv =
        page.select("div.SongPageGrid-sc-1vi6xda-0.DGVcp.Lyrics__Root-sc-1ynbvzw-0.jvlKWy")
    return if (oldDiv.isNotEmpty()) {
        oldDiv
    } else {
        newDiv
    }.text()
}