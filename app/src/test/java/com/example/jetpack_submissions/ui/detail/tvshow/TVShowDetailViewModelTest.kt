package com.example.jetpack_submissions.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem
import com.example.jetpack_submissions.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowDetailViewModelTest {

    private lateinit var viewModel: TVShowDetailViewModel
    private val tvshow = DataDummy.generateRemoteDummyTVShows()[0]

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<TVShowItem>

    @Before
    fun setUp() {
        viewModel = TVShowDetailViewModel()
        viewModel.setTVShowItem(tvshow)
    }

    @Test
    fun getTVShowItem() {
        val tvshowItem = viewModel.getTVShowItem().value
        Assert.assertNotNull(tvshowItem)
        Assert.assertEquals(tvshowItem?.name, tvshow.name)
        Assert.assertEquals(tvshowItem?.firstAirDate, tvshow.firstAirDate)
        Assert.assertEquals(tvshowItem?.popularity, tvshow.popularity)
        Assert.assertEquals(tvshowItem?.voteAverage, tvshow.voteAverage)
        Assert.assertEquals(tvshowItem?.voteCount, tvshow.voteCount)
        Assert.assertEquals(tvshowItem?.genreIds, tvshow.genreIds)
        Assert.assertEquals(tvshowItem?.overview, tvshow.overview)

        viewModel.getTVShowItem().observeForever(observer)
        verify(observer).onChanged(tvshow)
    }
}