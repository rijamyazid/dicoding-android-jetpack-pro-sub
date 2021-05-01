package com.example.jetpack_submissions.ui.home.movies

import com.example.jetpack_submissions.data.MovieEntity
import com.example.jetpack_submissions.ui.home.tvshows.TvshowsViewModel
import com.example.jetpack_submissions.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MoviesViewModelTest {

    lateinit var viewModel: MoviesViewModel
    lateinit var listMovies: List<MovieEntity>

    @Before
    fun setUp(){
        viewModel = MoviesViewModel()
        listMovies = DataDummy.generateDummyMovies()
    }

    @Test
    fun getDataTvshows() {
        val movies = viewModel.getDataMovies()
        assertNotNull(movies)
        assertEquals(listMovies.size, movies.size)
    }

    @Test
    fun getDataMovies() {
    }
}