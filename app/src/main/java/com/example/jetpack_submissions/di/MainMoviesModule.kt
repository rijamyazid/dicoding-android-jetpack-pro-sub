package com.example.jetpack_submissions.di

import android.content.Context
import androidx.room.Room
import com.example.jetpack_submissions.data.source.local.LocalDataSource
import com.example.jetpack_submissions.data.source.local.room.MovieDao
import com.example.jetpack_submissions.data.source.local.room.MoviesDatabase
import com.example.jetpack_submissions.data.source.local.room.TVShowDao
import com.example.jetpack_submissions.data.source.remote.RemoteDataSource
import com.example.jetpack_submissions.repository.Repository
import com.example.jetpack_submissions.utils.AppExecutors
import com.example.jetpack_submissions.utils.JsonHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainMoviesModule {

    @Singleton
    @Provides
    fun provideJsonHelper(@ApplicationContext context: Context): JsonHelper {
        return JsonHelper(context)
    }

    @Singleton
    @Provides
    fun provideRemoteDataSource(jsonHelper: JsonHelper): RemoteDataSource {
        return RemoteDataSource(jsonHelper)
    }

    @Singleton
    @Provides
    fun provideMoviesDatabase(@ApplicationContext context: Context): MoviesDatabase {
        return Room.databaseBuilder(
            context,
            MoviesDatabase::class.java,
            "Movies.db"
        ).allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideMovieDao(moviesDatabase: MoviesDatabase): MovieDao {
        return moviesDatabase.movieDao()
    }

    @Provides
    fun provideTVShowDao(moviesDatabase: MoviesDatabase): TVShowDao {
        return moviesDatabase.tvshowDao()
    }

    @Provides
    fun providelocalDataSource(movieDao: MovieDao, tvshowsDao: TVShowDao): LocalDataSource {
        return LocalDataSource(movieDao, tvshowsDao)
    }

    @Provides
    fun provideExecutors(): AppExecutors {
        return AppExecutors()
    }

    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource,
        executors: AppExecutors
    ): Repository {
        return Repository(localDataSource, remoteDataSource, executors)
    }

}