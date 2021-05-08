package com.example.jetpack_submissions.di

import android.content.Context
import com.example.jetpack_submissions.data.source.Repository
import com.example.jetpack_submissions.data.source.remote.RemoteDataSource
import com.example.jetpack_submissions.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): Repository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return Repository.getInstance(remoteDataSource)
    }

}