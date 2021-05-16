package com.example.jetpack_submissions.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.jetpack_submissions.data.source.local.LocalResponses
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity

interface DataSource {

    fun getMovieById(id: String): LiveData<MovieEntity>

    fun getTVShowById(id: String): LiveData<TVShowEntity>

    fun getAllRemoteMovies(): LiveData<LocalResponses<PagedList<MovieEntity>>>

    fun getAllRemoteTVShows(): LiveData<LocalResponses<PagedList<TVShowEntity>>>

    fun getAllFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    fun getAllFavoriteTVShows(): LiveData<PagedList<TVShowEntity>>

    fun setMovieFavoriteStatus(status: Boolean, movieId: String)

    fun setTVShowFavoriteStatus(status: Boolean, tvshowId: String)

}