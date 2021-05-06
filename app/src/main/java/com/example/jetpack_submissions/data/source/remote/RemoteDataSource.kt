package com.example.jetpack_submissions.data.source.remote

import androidx.lifecycle.MutableLiveData
import com.example.jetpack_submissions.BuildConfig
import com.example.jetpack_submissions.data.source.remote.api.ApiConfig
import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.data.source.remote.response.MovieResponse
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem
import com.example.jetpack_submissions.data.source.remote.response.TVShowResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource private constructor(private val callback: LoadingCallback) {

    val isMovieHomeOnLoad = MutableLiveData<Boolean>()

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

    fun getAllRemoteMovies(): MutableLiveData<ArrayList<MovieItem>> {
        callback.isOnLoadingState(true)
        val remoteMovies = MutableLiveData<ArrayList<MovieItem>>()
        val client =
            ApiConfig.getApiService().getMovies(BuildConfig.API_KEY, LANGUAGE_ENGLISH, PAGE_DEFAULT)
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    callback.isOnLoadingState(false)
                    remoteMovies.value = response.body()?.results as ArrayList<MovieItem>
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return remoteMovies
    }

    fun getAllRemoteTVShows(): MutableLiveData<ArrayList<TVShowItem>> {
        callback.isOnLoadingState(true)
        val remoteTVShows = MutableLiveData<ArrayList<TVShowItem>>()
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
                    remoteTVShows.value = response.body()?.results as ArrayList<TVShowItem>
                }
            }

            override fun onFailure(call: Call<TVShowResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return remoteTVShows
    }

}