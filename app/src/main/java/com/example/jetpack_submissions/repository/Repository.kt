package com.example.jetpack_submissions.repository

import androidx.lifecycle.LiveData
import com.example.jetpack_submissions.data.source.local.LocalDataSource
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.data.source.remote.RemoteDataSource
import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem
import com.example.jetpack_submissions.utils.Helpers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : DataSource {

    override fun getAllRemoteMovies(): LiveData<List<MovieEntity>> {
        remoteDataSource.getAllRemoteMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(moviesResponses: ArrayList<MovieItem>) {
                localDataSource.insertMovies(
                    Helpers.convertMoviesResponsesToEntities(moviesResponses)
                )
            }
        })
        return localDataSource.getAllMovies()
    }

    override fun getAllRemoteTVShows(): LiveData<List<TVShowEntity>> {
        remoteDataSource.getAllRemoteTVShows(object : RemoteDataSource.LoadTVShowCallback {
            override fun onAllTVShowsReceived(tvshowResponses: ArrayList<TVShowItem>) {
                localDataSource.insertTVShows(
                    Helpers.convertTVShowsResponsesToEntities(tvshowResponses)
                )
            }
        })
        return localDataSource.getAllTVShows()
    }

}