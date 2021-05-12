package com.example.jetpack_submissions.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.TypeConverters
import com.example.jetpack_submissions.data.source.local.room.ListStringConverters
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movieentity", primaryKeys = ["movie_id"])
data class MovieEntity(

    @ColumnInfo(name = "movie_isAdult")
    val adult: Boolean,

    @ColumnInfo(name = "movie_bPath")
    val backdropPath: String,

    @ColumnInfo(name = "movie_genres")
    @TypeConverters(ListStringConverters::class)
    val genreIds: List<String>,

    @NonNull
    @ColumnInfo(name = "movie_id")
    val id: String,

    @ColumnInfo(name = "movie_oriLang")
    val originalLanguage: String,

    @ColumnInfo(name = "movie_oriTitle")
    val originalTitle: String,

    @ColumnInfo(name = "movie_overview")
    val overview: String,

    @ColumnInfo(name = "movie_popularity")
    val popularity: String,

    @ColumnInfo(name = "movie_pPath")
    val posterPath: String,

    @ColumnInfo(name = "movie_releaseDate")
    val releaseDate: String,

    @ColumnInfo(name = "movie_title")
    val title: String,

    @ColumnInfo(name = "movie_isVideo")
    val video: Boolean,

    @ColumnInfo(name = "movie_vAverage")
    val voteAverage: String,

    @ColumnInfo(name = "movie_vCount")
    val voteCount: String,

    @ColumnInfo(name = "movie_isBookmarked")
    val bookmark: Boolean = false
):Parcelable
