package com.example.jetpack_submissions.data.source.local

import androidx.lifecycle.LiveData
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

    fun getMovieById(id: String): LiveData<MovieEntity> = movieDao.getMovieById(id)

    fun getTVShowById(id: String): LiveData<TVShowEntity> = tvShowDao.getTVShowById(id)

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = movieDao.getAllMovies()

    fun getAllTVShows(): DataSource.Factory<Int, TVShowEntity> = tvShowDao.getAllTVShows()

    fun getAllFavoriteMovies(): DataSource.Factory<Int, MovieEntity> =
        movieDao.getAllFavoriteMovies()

    fun getAllFavoriteTVShows(): DataSource.Factory<Int, TVShowEntity> =
        tvShowDao.getAllFavoriteTVShows()

    fun insertMovies(movies: List<MovieEntity>) {
        movieDao.insertMovies(movies)
    }

    fun insertTVShows(tvshows: List<TVShowEntity>) {
        tvShowDao.insertTVShows(tvshows)
    }

    fun setMovieFavoriteStatus(status: Boolean, movieId: String) {
        movieDao.setMovieFavoriteStatus(status, movieId)
    }

    fun setTVShowFavoriteStatus(status: Boolean, tvshowId: String) {
        tvShowDao.setTVShowFavoriteStatus(status, tvshowId)
    }

}