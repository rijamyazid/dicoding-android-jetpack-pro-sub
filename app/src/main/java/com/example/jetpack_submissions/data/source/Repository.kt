package com.example.jetpack_submissions.data.source

import androidx.lifecycle.LiveData
import com.example.jetpack_submissions.data.source.remote.RemoteDataSource
import com.example.jetpack_submissions.data.source.remote.response.MoviesItem

class Repository private constructor(private val remoteDataSource: RemoteDataSource) : DataSource {

    companion object {

        @Volatile
        private var instance: Repository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteDataSource).apply { instance = this }
            }

    }

    override fun getAllRemoteMovies(): LiveData<ArrayList<MoviesItem>> {
        return remoteDataSource.getAllRemoteMovies()
    }

}