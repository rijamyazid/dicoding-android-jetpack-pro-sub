package com.example.jetpack_submissions.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tvshowentity", primaryKeys = ["tvshow_id"])
data class TVShowEntity(

    @ColumnInfo(name = "tvshow_bPath")
    val backdropPath: String,

    @ColumnInfo(name = "tvshow_releaseDate")
    val firstAirDate: String,

    @ColumnInfo(name = "tvshow_genres")
    val genreIds: List<String>,

    @NonNull
    @ColumnInfo(name = "tvshow_id")
    val id: String,

    @ColumnInfo(name = "tvshow_title")
    val name: String,

    @ColumnInfo(name = "tvshow_oriCountry")
    val originCountry: List<String>,

    @ColumnInfo(name = "tvshow_oriLang")
    val originalLanguage: String,

    @ColumnInfo(name = "tvshow_oriTitle")
    val originalName: String,

    @ColumnInfo(name = "tvshow_overview")
    val overview: String,

    @ColumnInfo(name = "tvshow_popularity")
    val popularity: String,

    @ColumnInfo(name = "tvshow_pPath")
    val posterPath: String,

    @ColumnInfo(name = "tvshow_vAverage")
    val voteAverage: String,

    @ColumnInfo(name = "tvshow_vCount")
    val voteCount: String,

    @ColumnInfo(name = "tvshow_isFavorite")
    val favorite: Boolean = false
) : Parcelable
