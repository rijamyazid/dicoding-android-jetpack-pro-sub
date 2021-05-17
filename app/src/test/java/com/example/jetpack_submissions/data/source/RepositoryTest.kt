package com.example.jetpack_submissions.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.jetpack_submissions.data.source.local.LocalDataSource
import com.example.jetpack_submissions.data.source.local.LocalResponses
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.data.source.remote.RemoteDataSource
import com.example.jetpack_submissions.utils.AppExecutors
import com.example.jetpack_submissions.utils.DataDummy
import com.example.jetpack_submissions.utils.PagedListTestUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class RepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remoteDataSource = mock(RemoteDataSource::class.java)
    private val localDataSource = mock(LocalDataSource::class.java)
    private val executors = mock(AppExecutors::class.java)
    private val repository = FakeRepository(localDataSource, remoteDataSource, executors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val tvshowResponses = DataDummy.generateRemoteDummyTVShows()

    @Test
    fun getMovieById() {
        val movieId = DataDummy.generateDummyMovies()[0].id
        val movie = MutableLiveData(DataDummy.generateDummyMovies()[0])

        `when`(localDataSource.getMovieById(movieId)).thenReturn(movie)
        val movieEntity = repository.getMovieById(movieId)
        verify(localDataSource).getMovieById(movieId)

        assertNotNull(movieEntity)
        assertEquals(movieEntity.value?.id, movie.value?.id)
    }

    @Test
    fun getTVShowById() {
        val tvshowId = DataDummy.generateDummyTvshows()[0].id
        val tvshow = MutableLiveData(DataDummy.generateDummyTvshows()[0])

        `when`(localDataSource.getTVShowById(tvshowId)).thenReturn(tvshow)
        val tvshowEntity = repository.getTVShowById(tvshowId)
        verify(localDataSource).getTVShowById(tvshowId)

        assertNotNull(tvshowEntity)
        assertEquals(tvshowEntity.value?.id, tvshow.value?.id)
    }

    @Test
    fun getAllRemoteMovies() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(localDataSource.getAllMovies()).thenReturn(dataSourceFactory)
        repository.getAllRemoteMovies()

        val movieEntities =
            LocalResponses.success(PagedListTestUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(localDataSource).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllRemoteTVShows() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowEntity>
        `when`(localDataSource.getAllTVShows()).thenReturn(dataSourceFactory)
        repository.getAllRemoteTVShows()

        val tvshowEntities =
            LocalResponses.success(PagedListTestUtil.mockPagedList(DataDummy.generateDummyTvshows()))
        verify(localDataSource).getAllTVShows()
        assertNotNull(tvshowEntities.data)
        assertEquals(tvshowResponses.size.toLong(), tvshowEntities.data?.size?.toLong())
    }

    @Test
    fun getAllFavoriteMovies() {
        val favoriteMovies = DataDummy.generateDummyMovies()

        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(localDataSource.getAllFavoriteMovies()).thenReturn(dataSourceFactory)
        repository.getAllFavoriteMovies()

        val movieEntities = PagedListTestUtil.mockPagedList(DataDummy.generateDummyMovies())
        verify(localDataSource).getAllFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(favoriteMovies.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllFavoriteTVShows() {
        val favoriteTVShows = DataDummy.generateDummyTvshows()

        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowEntity>
        `when`(localDataSource.getAllFavoriteTVShows()).thenReturn(dataSourceFactory)
        repository.getAllFavoriteTVShows()

        val tvshowEntities = PagedListTestUtil.mockPagedList(DataDummy.generateDummyTvshows())
        verify(localDataSource).getAllFavoriteTVShows()
        assertNotNull(tvshowEntities)
        assertEquals(favoriteTVShows.size.toLong(), tvshowEntities.size.toLong())
    }
}