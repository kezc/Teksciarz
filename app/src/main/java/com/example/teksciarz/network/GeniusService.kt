package com.example.teksciarz.network

import com.example.teksciarz.BuildConfig
import com.example.teksciarz.data.GeniusSearchData
import com.example.teksciarz.data.GeniusSearchResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GeniusService {
    @GET("search")
    suspend fun searchSong(@Query("q") phrase: String): GeniusSearchData

    companion object {
        private const val BASE_URL = "https://api.genius.com"

        fun create(): GeniusService {
            val client = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer ${BuildConfig.GENIUS_API_KEY}")
                        .build()
                    chain.proceed(newRequest)
                }.build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GeniusService::class.java)
        }
    }
}