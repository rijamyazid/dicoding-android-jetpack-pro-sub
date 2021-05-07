package com.example.jetpack_submissions.data.source.remote

import com.example.jetpack_submissions.BuildConfig
import com.example.jetpack_submissions.data.source.remote.api.ApiConfig
import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.data.source.remote.response.MovieResponse
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem
import com.example.jetpack_submissions.data.source.remote.response.TVShowResponse
import com.example.jetpack_submissions.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {

        const val LANGUAGE_ENGLISH = "en-US"
        const val PAGE_DEFAULT = "1"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }

    }

    fun getAllRemoteMovies(moviesCallback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        moviesCallback.isOnLoadingStates(true)
        moviesCallback.isConnectionSuccessful(true)
        val client =
            ApiConfig.getApiService().getMovies(BuildConfig.API_KEY, LANGUAGE_ENGLISH, PAGE_DEFAULT)
        client.enqueue(object : Callback<MovieResponse> {

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    moviesCallback.isOnLoadingStates(false)
                    moviesCallback.onAllMoviesReceived(response.body()?.results as ArrayList<MovieItem>)
                    EspressoIdlingResource.decrement()
                } else {
                    moviesCallback.isOnLoadingStates(false)
                    moviesCallback.isConnectionSuccessful(false)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                moviesCallback.isOnLoadingStates(false)
                moviesCallback.isConnectionSuccessful(false)
            }

        })

    }

    fun getAllRemoteTVShows(tvshowCallback: LoadTVShowCallback) {
        EspressoIdlingResource.increment()
        tvshowCallback.isOnLoadingStates(true)
        tvshowCallback.isConnectionSuccessful(true)
        val client =
            ApiConfig.getApiService()
                .getTVShows(BuildConfig.API_KEY, LANGUAGE_ENGLISH, PAGE_DEFAULT)
        client.enqueue(object : Callback<TVShowResponse> {

            override fun onResponse(
                call: Call<TVShowResponse>,
                response: Response<TVShowResponse>
            ) {
                if (response.isSuccessful) {
                    EspressoIdlingResource.decrement()
                    tvshowCallback.isOnLoadingStates(false)
                    tvshowCallback.onAllTVShowsReceived(response.body()?.results as ArrayList<TVShowItem>)
                } else {
                    tvshowCallback.isOnLoadingStates(false)
                    tvshowCallback.isConnectionSuccessful(false)
                }
            }

            override fun onFailure(call: Call<TVShowResponse>, t: Throwable) {
                tvshowCallback.isOnLoadingStates(false)
                tvshowCallback.isConnectionSuccessful(false)
            }

        })
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(moviesResponses: ArrayList<MovieItem>)
        fun isOnLoadingStates(status: Boolean)
        fun isConnectionSuccessful(status: Boolean)
    }

    interface LoadTVShowCallback {
        fun onAllTVShowsReceived(tvshowResponses: ArrayList<TVShowItem>)
        fun isOnLoadingStates(status: Boolean)
        fun isConnectionSuccessful(status: Boolean)
    }

}