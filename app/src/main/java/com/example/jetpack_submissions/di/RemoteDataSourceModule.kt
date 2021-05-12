package com.example.jetpack_submissions.di

import android.content.Context
import com.example.jetpack_submissions.data.source.remote.RemoteDataSource
import com.example.jetpack_submissions.repository.Repository
import com.example.jetpack_submissions.utils.JsonHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideJsonHelper(context: Context): JsonHelper {
        return JsonHelper(context)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(jsonHelper: JsonHelper): RemoteDataSource {
        return RemoteDataSource(jsonHelper)
    }

    @Provides
    fun provideRepository(remoteDataSource: RemoteDataSource): Repository {
        return Repository(remoteDataSource)
    }

}