package com.example.floclone

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Song::class, User::class], version = 1)
abstract class SongDatabase: RoomDatabase(){
    abstract fun songDao(): SongDao
    abstract fun UserDao(): UserDao

    companion object{
        private var instance: SongDatabase? = null
        @Synchronized
        fun getInstance(context: Context): SongDatabase?{
            if(instance == null){
                synchronized(SongDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SongDatabase::class.java,
                        "song-database" //다른 이름이랑 겹치면 꼬임
                    ).allowMainThreadQueries().build()
                }
            }
            return instance
        }
    }
}