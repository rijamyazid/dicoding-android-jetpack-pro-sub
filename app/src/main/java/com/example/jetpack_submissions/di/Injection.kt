package com.example.jetpack_submissions.di

import com.example.jetpack_submissions.data.source.Repository
import com.example.jetpack_submissions.data.source.remote.RemoteDataSource

object Injection {

    fun provideRepository(): Repository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return Repository.getInstance(remoteDataSource)
    }

}