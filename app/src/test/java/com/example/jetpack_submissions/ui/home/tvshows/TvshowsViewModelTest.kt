package com.example.jetpack_submissions.ui.home.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.jetpack_submissions.data.source.Repository
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem
import com.example.jetpack_submissions.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvshowsViewModelTest {

    private lateinit var viewModel: TvshowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var observer1: Observer<ArrayList<TVShowItem>>

    @Mock
    private lateinit var observer2: Observer<Boolean>

    @Before
    fun setUp() {
        viewModel = TvshowsViewModel(repository)
    }

    @Test
    fun getDataTvshows() {

        val dummyTVShows = DataDummy.generateRemoteDummyTVShows()
        val tvshows = MutableLiveData<ArrayList<TVShowItem>>()
        tvshows.value = dummyTVShows

        `when`(repository.getAllRemoteTVShows()).thenReturn(tvshows)
        val tvshowItems = viewModel.getDataTvshows().value
        verify(repository).getAllRemoteTVShows()

        assertNotNull(tvshowItems)
        assertEquals(dummyTVShows.size, tvshowItems?.size)

        viewModel.getDataTvshows().observeForever(observer1)
        verify(observer1).onChanged(dummyTVShows)
    }

    @Test
    fun getLoadingStates() {
        val onLoad = true
        val onLoadLiveData = MutableLiveData<Boolean>()
        onLoadLiveData.value = onLoad

        `when`(repository.isOnloadingStates).thenReturn(onLoadLiveData)
        val loadStates = viewModel.getLoadingStates().value
        verify(repository).isOnloadingStates

        assertNotNull(loadStates)
        assertEquals(onLoad, loadStates)

        viewModel.getLoadingStates().observeForever(observer2)
        verify(observer2).onChanged(onLoad)
    }

    @Test
    fun getConnectionStates() {
        val connectionSuccess = true
        val connectionSuccessLiveData = MutableLiveData<Boolean>()
        connectionSuccessLiveData.value = connectionSuccess

        `when`(repository.isConnectionSuccessful).thenReturn(connectionSuccessLiveData)
        val connectionStates = viewModel.getConnectionStates().value
        verify(repository).isConnectionSuccessful

        assertNotNull(connectionStates)
        assertEquals(connectionSuccess, connectionStates)

        viewModel.getConnectionStates().observeForever(observer2)
        verify(observer2).onChanged(connectionSuccess)
    }

}