package com.example.jetpack_submissions.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
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

    override fun getMovieById(id: String): LiveData<MovieEntity> {
        return localDataSource.getMovieById(id)
    }

    override fun getTVShowById(id: String): LiveData<TVShowEntity> {
        return localDataSource.getTVShowById(id)
    }

    override fun getAllRemoteMovies(): LiveData<LocalResponses<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieItem>>(executors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean {
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

    override fun getAllRemoteTVShows(): LiveData<LocalResponses<PagedList<TVShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TVShowEntity>, List<TVShowItem>>(executors) {
            override fun loadFromDB(): LiveData<PagedList<TVShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTVShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TVShowEntity>?): Boolean {
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

    override fun getAllFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getAllFavoriteMovies(), config).build()
    }

    override fun getAllFavoriteTVShows(): LiveData<PagedList<TVShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getAllFavoriteTVShows(), config).build()
    }

    override fun setMovieFavoriteStatus(status: Boolean, movieId: String) {
        executors.diskIO().execute {
            localDataSource.setMovieFavoriteStatus(status, movieId)
        }
    }

    override fun setTVShowFavoriteStatus(status: Boolean, tvshowId: String) {
        executors.diskIO().execute {
            localDataSource.setTVShowFavoriteStatus(status, tvshowId)
        }
    }

}