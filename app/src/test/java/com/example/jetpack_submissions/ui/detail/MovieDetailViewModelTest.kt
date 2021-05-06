package com.example.jetpack_submissions.ui.detail

import com.example.jetpack_submissions.ui.detail.movie.MovieDetailViewModel
import com.example.jetpack_submissions.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieDetailViewModelTest {

    private lateinit var viewModel: MovieDetailViewModel
    private val movie = DataDummy.generateDummyMovies()[0]

    @Before
    fun setUp() {
        viewModel = MovieDetailViewModel()
        viewModel.setMovieEntity(movie)
    }

    @Test
    fun getMovieEntity() {
        assertNotNull(viewModel.getMovieEntity())
        assertEquals(viewModel.getMovieEntity()?.title, movie.title)
        assertEquals(viewModel.getMovieEntity()?.releaseYear, movie.releaseYear)
        assertEquals(viewModel.getMovieEntity()?.country, movie.country)
        assertEquals(viewModel.getMovieEntity()?.director, movie.director)
        assertEquals(viewModel.getMovieEntity()?.genre, movie.genre)
        assertEquals(viewModel.getMovieEntity()?.desc, movie.desc)
    }
}