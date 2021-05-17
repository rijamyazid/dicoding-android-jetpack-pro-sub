package com.example.jetpack_submissions.ui.home.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PositionalDataSource
import com.example.jetpack_submissions.data.source.local.LocalResponses
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.repository.Repository
import com.example.jetpack_submissions.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import java.util.concurrent.Executors

@RunWith(MockitoJUnitRunner::class)
class MoviesViewModelTest {

    private lateinit var viewModel: MoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer: Observer<LocalResponses<PagedList<MovieEntity>>>

    @Mock
    private lateinit var observer1: Observer<PagedList<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(repository)
    }

    @Test
    fun getDataMovies() {
        val movies = PagedTestDataSources.snapshot(DataDummy.generateDummyMovies())
        val expected = MutableLiveData<LocalResponses<PagedList<MovieEntity>>>()
        expected.value = LocalResponses.success(movies)

        `when`(repository.getAllRemoteMovies()).thenReturn(expected)

        viewModel.getDataMovies().observeForever(observer)
        verify(observer).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getDataMovies().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.data, actualValue?.data)
        assertEquals(expectedValue?.data?.size, actualValue?.data?.size)
    }

    @Test
    fun getDataFavoriteMovies() {
        val movies = PagedTestDataSources.snapshot(DataDummy.generateDummyMovies())
        val expected = MutableLiveData<PagedList<MovieEntity>>()
        expected.value = movies

        `when`(repository.getAllFavoriteMovies()).thenReturn(expected)

        viewModel.getDataFavoriteMovies().observeForever(observer1)
        verify(observer1).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getDataFavoriteMovies().value
        assertEquals(expectedValue, actualValue)
        assertEquals(expectedValue?.size, actualValue?.size)
    }

    class PagedTestDataSources private constructor(private val items: List<MovieEntity>) :
        PositionalDataSource<MovieEntity>() {
        companion object {
            fun snapshot(items: List<MovieEntity> = listOf()): PagedList<MovieEntity> {
                return PagedList.Builder(PagedTestDataSources(items), 10)
                    .setNotifyExecutor(Executors.newSingleThreadExecutor())
                    .setFetchExecutor(Executors.newSingleThreadExecutor())
                    .build()
            }
        }

        override fun loadInitial(
            params: LoadInitialParams,
            callback: LoadInitialCallback<MovieEntity>
        ) {
            callback.onResult(items, 0, items.size)
        }

        override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<MovieEntity>) {
            val start = params.startPosition
            val end = params.startPosition + params.loadSize
            callback.onResult(items.subList(start, end))
        }
    }

}