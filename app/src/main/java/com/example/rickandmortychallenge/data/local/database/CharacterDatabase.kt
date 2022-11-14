package com.example.rickandmortychallenge.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.rickandmortychallenge.data.local.dao.CharacterDao
import com.example.rickandmortychallenge.data.local.entity.CharacterEntity

@Database(entities = [CharacterEntity::class], version = 1)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao

    companion object{
        private var INSTANCE: CharacterDatabase ?= null

        fun getDatabase(context: Context): CharacterDatabase{
            INSTANCE = INSTANCE?: Room.databaseBuilder(
                context.applicationContext,
                CharacterDatabase::class.java,
                "character_table"
            ).build()
            return INSTANCE!!
        }
        fun destroyInstance(){
            INSTANCE=null
        }
    }
}