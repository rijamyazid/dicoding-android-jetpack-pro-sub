package com.example.jetpack_submissions.ui.home.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.jetpack_submissions.data.source.Repository
import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer1: Observer<ArrayList<MovieItem>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(repository)
    }

    @Test
    fun getAllRemoteMovies() {

        val dummyMovies = DataDummy.generateRemoteDummyMovies()
        val movies = MutableLiveData<ArrayList<MovieItem>>()
        movies.value = dummyMovies

        `when`(repository.getAllRemoteMovies()).thenReturn(movies)
        val movieItems = viewModel.getAllRemoteMovies().value
        verify(repository).getAllRemoteMovies()

        assertNotNull(movieItems)
        assertEquals(dummyMovies.size, movieItems?.size)

        viewModel.getAllRemoteMovies().observeForever(observer1)
        verify(observer1).onChanged(dummyMovies)
    }

}