package com.example.jetpack_submissions.ui.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.repository.Repository
import com.example.jetpack_submissions.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieDetailViewModelTest {

    private lateinit var viewModel: MovieDetailViewModel
    private val movie = DataDummy.generateDummyMovies()[0]

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<MovieEntity>

    @Mock
    private lateinit var repository: Repository

    @Before
    fun setUp() {
        viewModel = MovieDetailViewModel(repository)
        viewModel.setMovieEntity(movie)
        viewModel.setMovieFavoriteStatus()
    }

    @Test
    fun getMovieItem() {
        val expected = MutableLiveData<MovieEntity>()
        expected.value = movie

        `when`(repository.getMovieById(movie.id)).thenReturn(expected)

        viewModel.movieEntity.observeForever(observer)
        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.movieEntity.value

        assertEquals(expectedValue, actualValue)
        assertNotNull(actualValue)
        assertEquals(expectedValue?.title, actualValue?.title)
        assertEquals(expectedValue?.releaseDate, actualValue?.releaseDate)
        assertEquals(expectedValue?.popularity, actualValue?.popularity)
        assertEquals(expectedValue?.voteAverage, actualValue?.voteAverage)
        assertEquals(expectedValue?.voteCount, actualValue?.voteCount)
        assertEquals(expectedValue?.genreIds, actualValue?.genreIds)
        assertEquals(expectedValue?.overview, actualValue?.overview)
        assertEquals(expectedValue?.favorite, actualValue?.favorite)

    }
}