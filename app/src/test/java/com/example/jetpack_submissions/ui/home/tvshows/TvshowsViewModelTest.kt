package com.example.jetpack_submissions.ui.home.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.example.jetpack_submissions.data.source.local.LocalResponses
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.repository.Repository
import com.example.jetpack_submissions.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class TvshowsViewModelTest {

    private lateinit var viewModel: TvshowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<LocalResponses<PagedList<TVShowEntity>>>

    @Mock
    private lateinit var observer1: Observer<PagedList<TVShowEntity>>

    @Before
    fun setUp() {
        viewModel = TvshowsViewModel(repository)
    }

    @Test
    fun getDataTvshows() {
        val tvshows = PagedTestDataSources.snapshot(DataDummy.generateDummyTvshows())
        val expected = MutableLiveData<LocalResponses<PagedList<TVShowEntity>>>()
        expected.value = LocalResponses.success(tvshows)

        Mockito.`when`(repository.getAllRemoteTVShows()).thenReturn(expected)

        viewModel.getDataTVShows().observeForever(observer)
        Mockito.verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getDataTVShows().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.data, actualValue?.data)
        assertEquals(expectedValue?.data?.size, actualValue?.data?.size)
    }

    @Test
    fun getDataFavoriteTVShows() {
        val movies = PagedTestDataSources.snapshot(DataDummy.generateDummyTvshows())
        val expected = MutableLiveData<PagedList<TVShowEntity>>()
        expected.value = movies

        Mockito.`when`(repository.getAllFavoriteTVShows()).thenReturn(expected)

        viewModel.getDataFavoriteTVShows().observeForever(observer1)
        Mockito.verify(observer1).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getDataFavoriteTVShows().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.size, actualValue?.size)
    }

    class PagedTestDataSources private constructor(private val items: List<TVShowEntity>) :
        PositionalDataSource<TVShowEntity>() {
        companion object {
            fun snapshot(items: List<TVShowEntity> = listOf()): PagedList<TVShowEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(
            params: LoadInitialParams,
            callback: LoadInitialCallback<TVShowEntity>
        ) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<TVShowEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }

}