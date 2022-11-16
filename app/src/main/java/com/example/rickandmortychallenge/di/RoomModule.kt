package com.example.rickandmortychallenge.di

import android.content.Context
import androidx.room.Room
import com.example.rickandmortychallenge.data.local.database.CharacterDatabase
import com.example.rickandmortychallenge.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CharacterDatabase::class.java, Constants.MOVIE_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideMovieDatabase(characterDatabase: CharacterDatabase) = characterDatabase.characterDao()
}