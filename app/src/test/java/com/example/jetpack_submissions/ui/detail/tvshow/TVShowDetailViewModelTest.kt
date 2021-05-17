package com.example.jetpack_submissions.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.repository.Repository
import com.example.jetpack_submissions.utils.DataDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TVShowDetailViewModelTest {

    private lateinit var viewModel: TVShowDetailViewModel
    private val tvshow = DataDummy.generateDummyTvshows()[0]

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<TVShowEntity>

    @Mock
    private lateinit var repository: Repository

    @Before
    fun setUp() {
        viewModel = TVShowDetailViewModel(repository)
        viewModel.setTVShowEntity(tvshow)
        viewModel.setTVShowFavoriteStatus()
    }

    @Test
    fun getTVShowItem() {
        val expected = MutableLiveData<TVShowEntity>()
        expected.value = tvshow

        `when`(repository.getTVShowById(tvshow.id)).thenReturn(expected)

        viewModel.tvshowEntity.observeForever(observer)
        Mockito.verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.tvshowEntity.value

        Assert.assertEquals(expectedValue, actualValue)
        Assert.assertNotNull(actualValue)
        Assert.assertEquals(expectedValue?.name, actualValue?.name)
        Assert.assertEquals(expectedValue?.firstAirDate, actualValue?.firstAirDate)
        Assert.assertEquals(expectedValue?.popularity, actualValue?.popularity)
        Assert.assertEquals(expectedValue?.voteAverage, actualValue?.voteAverage)
        Assert.assertEquals(expectedValue?.voteCount, actualValue?.voteCount)
        Assert.assertEquals(expectedValue?.genreIds, actualValue?.genreIds)
        Assert.assertEquals(expectedValue?.overview, actualValue?.overview)
        Assert.assertEquals(expectedValue?.favorite, actualValue?.favorite)
    }
}