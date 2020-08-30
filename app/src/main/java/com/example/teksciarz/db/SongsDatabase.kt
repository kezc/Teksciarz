package com.example.teksciarz.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DbSong::class], version = 3, exportSchema = false)
abstract class SongsDatabase : RoomDatabase() {
    abstract fun songsDao(): SongsDao

    companion object {
        @Volatile
        private var INSTANCE: SongsDatabase? = null

        fun getInstance(context: Context): SongsDatabase =
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context, SongsDatabase::class.java, "songs_database")
                            .fallbackToDestructiveMigration()
                            .build()
                }
                return instance
            }

    }
}