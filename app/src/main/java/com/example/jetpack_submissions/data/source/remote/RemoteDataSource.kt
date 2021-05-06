package com.example.jetpack_submissions.data.source.remote

import androidx.lifecycle.MutableLiveData
import com.example.jetpack_submissions.BuildConfig
import com.example.jetpack_submissions.data.source.remote.api.ApiConfig
import com.example.jetpack_submissions.data.source.remote.response.MovieResponse
import com.example.jetpack_submissions.data.source.remote.response.MoviesItem
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

    fun getAllRemoteMovies(): MutableLiveData<ArrayList<MoviesItem>> {
        var remoteMovies = MutableLiveData<ArrayList<MoviesItem>>()
        val client =
            ApiConfig.getApiService().getMovies(BuildConfig.API_KEY, LANGUAGE_ENGLISH, PAGE_DEFAULT)
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    remoteMovies.value = response.body()?.results as ArrayList<MoviesItem>
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return remoteMovies
    }

}