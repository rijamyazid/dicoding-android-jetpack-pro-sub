package com.example.jetpack_submissions.data.source.local

import androidx.paging.DataSource
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.data.source.local.room.MovieDao
import com.example.jetpack_submissions.data.source.local.room.TVShowDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val movieDao: MovieDao,
    private val tvShowDao: TVShowDao
) {

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = movieDao.getAllMovies()

    fun getAllTVShows(): DataSource.Factory<Int, TVShowEntity> = tvShowDao.getAllTVShows()

    fun insertMovies(movies: List<MovieEntity>) {
        movieDao.insertMovies(movies)
    }

    fun insertTVShows(tvshows: List<TVShowEntity>) {
        tvShowDao.insertTVShows(tvshows)
    }

}