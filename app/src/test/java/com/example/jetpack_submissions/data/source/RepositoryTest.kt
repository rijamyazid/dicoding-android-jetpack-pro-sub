package com.example.jetpack_submissions.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.jetpack_submissions.data.source.remote.RemoteDataSource
import com.example.jetpack_submissions.utils.DataDummy
import com.example.jetpack_submissions.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class RepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val repository = FakeRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val tvshowResponses = DataDummy.generateRemoteDummyTVShows()

    @Test
    fun getAllRemoteMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllRemoteMovies(any())
        val movieItems = LiveDataTestUtil.getValue(repository.getAllRemoteMovies())
        verify(remote).getAllRemoteMovies(any())

        assertNotNull(movieItems)
        assertEquals(movieResponses.size.toLong(), movieItems.size.toLong())
    }

    @Test
    fun getAllRemoteTVShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTVShowCallback)
                .onAllTVShowsReceived(tvshowResponses)
            null
        }.`when`(remote).getAllRemoteTVShows(any())
        val tvshowsItems = LiveDataTestUtil.getValue(repository.getAllRemoteTVShows())
        verify(remote).getAllRemoteTVShows(any())

        assertNotNull(tvshowsItems)
        assertEquals(tvshowResponses.size.toLong(), tvshowsItems.size.toLong())
    }
}