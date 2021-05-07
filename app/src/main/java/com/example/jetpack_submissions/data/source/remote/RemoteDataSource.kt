package com.example.jetpack_submissions.data.source.remote

import com.example.jetpack_submissions.BuildConfig
import com.example.jetpack_submissions.data.ConnectionStatus
import com.example.jetpack_submissions.data.source.remote.api.ApiConfig
import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.data.source.remote.response.MovieResponse
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem
import com.example.jetpack_submissions.data.source.remote.response.TVShowResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val callback: LoadingCallback) {

    companion object {

        const val LANGUAGE_ENGLISH = "en-US"
        const val PAGE_DEFAULT = "1"

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(callback: LoadingCallback): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(callback).apply { instance = this }
            }

    }

    fun getAllRemoteMovies(moviesCallback: LoadMoviesCallback) {
        callback.isOnLoadingState(true)
        callback.isConnectionSuccesfull(ConnectionStatus(true, ""))

        val client =
            ApiConfig.getApiService().getMovies(BuildConfig.API_KEY, LANGUAGE_ENGLISH, PAGE_DEFAULT)
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    callback.isOnLoadingState(false)
                    moviesCallback.onAllMoviesReceived(response.body()?.results as ArrayList<MovieItem>)
                } else {
                    callback.isOnLoadingState(false)
                    callback.isConnectionSuccesfull(ConnectionStatus(false, response.message()))
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                callback.isOnLoadingState(false)
                callback.isConnectionSuccesfull(
                    ConnectionStatus(
                        false,
                        "Terjadi masalah dengan jaringan anda, Memuat data cache"
                    )
                )
            }

        })

    }

    fun getAllRemoteTVShows(tvshowCallback: LoadTVShowCallback) {
        callback.isOnLoadingState(true)
        callback.isConnectionSuccesfull(ConnectionStatus(true, ""))
        val client =
            ApiConfig.getApiService()
                .getTVShows(BuildConfig.API_KEY, LANGUAGE_ENGLISH, PAGE_DEFAULT)
        client.enqueue(object : Callback<TVShowResponse> {
            override fun onResponse(
                call: Call<TVShowResponse>,
                response: Response<TVShowResponse>
            ) {
                if (response.isSuccessful) {
                    callback.isOnLoadingState(false)
                    tvshowCallback.onAllTVShowsReceived(response.body()?.results as ArrayList<TVShowItem>)
                } else {
                    callback.isOnLoadingState(false)
                    callback.isConnectionSuccesfull(ConnectionStatus(false, response.message()))
                }
            }

            override fun onFailure(call: Call<TVShowResponse>, t: Throwable) {
                callback.isOnLoadingState(false)
                callback.isConnectionSuccesfull(
                    ConnectionStatus(
                        false,
                        "Terjadi masalah dengan jaringan anda"
                    )
                )
            }

        })
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(moviesResponses: ArrayList<MovieItem>)
        fun isOnLoadingStates(status: Boolean)
        fun isConnectionSuccesfull(status: Boolean)
    }

    interface LoadTVShowCallback {
        fun onAllTVShowsReceived(tvshowResponses: ArrayList<TVShowItem>)
    }

}