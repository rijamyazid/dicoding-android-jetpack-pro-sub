package com.example.jetpack_submissions.ui.home.tvshows

import com.example.jetpack_submissions.data.MovieEntity
import com.example.jetpack_submissions.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvshowsViewModelTest {

    lateinit var viewModel: TvshowsViewModel
    lateinit var listTvshows: List<MovieEntity>

    @Before
    fun setUp(){
        viewModel = TvshowsViewModel()
        listTvshows = DataDummy.generateDummyTvshows()
    }

    @Test
    fun getDataTvshows() {
        val tvShows = viewModel.getDataTvshows()
        assertNotNull(tvShows)
        assertEquals(listTvshows.size, tvShows.size)
    }
}