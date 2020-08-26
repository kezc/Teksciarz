package com.example.teksciarz.network

import kotlinx.coroutines.runBlocking
import org.junit.Test

class GeniusScrapperKtTest {

    @Test
    fun getPageTest() = runBlocking {
        val doc = getPage("https://genius.com/Pikers-charon-lyrics")
        print(getLyrics(doc))
    }
}