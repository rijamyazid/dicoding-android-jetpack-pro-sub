package com.example.jetpack_submissions.repository

import androidx.lifecycle.LiveData
import com.example.jetpack_submissions.data.source.local.LocalDataSource
import com.example.jetpack_submissions.data.source.local.LocalResponses
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.data.source.remote.RemoteDataSource
import com.example.jetpack_submissions.data.source.remote.RemoteResponses
import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem
import com.example.jetpack_submissions.utils.AppExecutors
import com.example.jetpack_submissions.utils.Helpers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val executors: AppExecutors
) : DataSource {

    override fun getAllRemoteMovies(): LiveData<LocalResponses<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<MovieItem>>(executors) {
            override fun loadFromDB(): LiveData<List<MovieEntity>> {
                return localDataSource.getAllMovies()
            }

            override fun shouldFetch(data: List<MovieEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<RemoteResponses<List<MovieItem>>> {
                return remoteDataSource.getAllRemoteMovies()
            }

            override fun saveCallResult(data: List<MovieItem>) {
                val moviesConverted = Helpers.convertMoviesResponsesToEntities(data)
                localDataSource.insertMovies(moviesConverted)
            }
        }.asLiveData()
    }

    override fun getAllRemoteTVShows(): LiveData<LocalResponses<List<TVShowEntity>>> {
        return object : NetworkBoundResource<List<TVShowEntity>, List<TVShowItem>>(executors) {
            override fun loadFromDB(): LiveData<List<TVShowEntity>> {
                return localDataSource.getAllTVShows()
            }

            override fun shouldFetch(data: List<TVShowEntity>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun createCall(): LiveData<RemoteResponses<List<TVShowItem>>> {
                return remoteDataSource.getAllRemoteTVShows()
            }

            override fun saveCallResult(data: List<TVShowItem>) {
                val tvshowsConverted = Helpers.convertTVShowsResponsesToEntities(data)
                localDataSource.insertTVShows(tvshowsConverted)
            }
        }.asLiveData()
    }

}