package com.example.teksciarz.network

import org.jsoup.Jsoup
import org.junit.Test

class GeniusScrapperKtTest {

//    @Test
//    fun getOldLyricsTest() {
//        getLyrics(MockupTexts.old)
//    }
////
//    @Test
//    fun getNewLyricsTest() {
//        getLyrics(MockupTexts.new)
//    }

    @Test
    fun getLyricsTest() {
        val p = getPage("https://genius.com/Kendrick-lamar-humble-lyrics")
        val l = getLyrics(p)
        println(l)
    }
}
