package com.example.jetpack_submissions.di

import com.example.jetpack_submissions.data.source.Repository
import com.example.jetpack_submissions.data.source.remote.LoadingCallback
import com.example.jetpack_submissions.data.source.remote.RemoteDataSource

object Injection {

    fun provideRepository(callback: LoadingCallback): Repository {

        val remoteDataSource = RemoteDataSource.getInstance(callback)

        return Repository.getInstance(remoteDataSource)
    }

}