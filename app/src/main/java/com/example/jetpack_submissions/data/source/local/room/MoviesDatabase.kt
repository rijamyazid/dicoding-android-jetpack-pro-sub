package com.example.jetpack_submissions.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import javax.inject.Singleton

@Singleton
@Database(entities = [MovieEntity::class, TVShowEntity::class], version = 1, exportSchema = false)
@TypeConverters(ListStringConverters::class)
abstract class MoviesDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    abstract fun tvshowDao(): TVShowDao

}