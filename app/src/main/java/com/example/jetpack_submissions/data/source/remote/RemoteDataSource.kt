package com.example.jetpack_submissions.data.source.remote

import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem
import com.example.jetpack_submissions.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    companion object {

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(jsonHelper: JsonHelper): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(jsonHelper).apply { instance = this }
            }

    }

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