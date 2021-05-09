package com.example.jetpack_submissions.data.source.remote

import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem
import com.example.jetpack_submissions.utils.JsonHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val jsonHelper: JsonHelper) {

    fun getAllRemoteMovies(moviesCallback: LoadMoviesCallback) {
        moviesCallback.onAllMoviesReceived(jsonHelper.loadRemoteMovies())
    }

    fun getAllRemoteTVShows(tvshowCallback: LoadTVShowCallback) {
        tvshowCallback.onAllTVShowsReceived(jsonHelper.loadRemoteTVShows())
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(moviesResponses: ArrayList<MovieItem>)
    }

    interface LoadTVShowCallback {
        fun onAllTVShowsReceived(tvshowResponses: ArrayList<TVShowItem>)
    }

}