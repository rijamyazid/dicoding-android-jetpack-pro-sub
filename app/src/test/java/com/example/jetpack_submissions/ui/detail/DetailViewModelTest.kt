package com.example.jetpack_submissions.ui.detail

import com.example.jetpack_submissions.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val movie = DataDummy.generateDummyMovies()[0]

    @Before
    fun setUp(){
        viewModel = DetailViewModel()
        viewModel.setMovieEntity(movie)
    }

    @Test
    fun getMovieEntity() {
        assertNotNull(viewModel.getMovieEntity())
        assertEquals(viewModel.getMovieEntity().title, movie.title)
        assertEquals(viewModel.getMovieEntity().releaseYear, movie.releaseYear)
        assertEquals(viewModel.getMovieEntity().country, movie.country)
        assertEquals(viewModel.getMovieEntity().director, movie.director)
        assertEquals(viewModel.getMovieEntity().genre, movie.genre)
        assertEquals(viewModel.getMovieEntity().desc, movie.desc)
    }
}