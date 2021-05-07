package com.example.jetpack_submissions.ui.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
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
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieDetailViewModelTest {

    private lateinit var viewModel: MovieDetailViewModel
    private val movie = DataDummy.generateRemoteDummyMovies()[0]

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<MovieItem>

    @Before
    fun setUp() {
        viewModel = MovieDetailViewModel()
        viewModel.setMovieItem(movie)
    }

    @Test
    fun getMovieItem() {
        val movieItem = viewModel.getMovieItem().value
        assertNotNull(movieItem)
        assertEquals(movieItem?.title, movie.title)
        assertEquals(movieItem?.releaseDate, movie.releaseDate)
        assertEquals(movieItem?.popularity, movie.popularity)
        assertEquals(movieItem?.voteAverage, movie.voteAverage)
        assertEquals(movieItem?.voteCount, movie.voteCount)
        assertEquals(movieItem?.genreIds, movie.genreIds)
        assertEquals(movieItem?.overview, movie.overview)

        viewModel.getMovieItem().observeForever(observer)
        verify(observer).onChanged(movie)
    }
}