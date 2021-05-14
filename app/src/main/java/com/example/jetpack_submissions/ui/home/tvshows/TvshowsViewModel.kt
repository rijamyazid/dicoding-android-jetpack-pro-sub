package com.example.jetpack_submissions.ui.home.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.jetpack_submissions.data.source.local.LocalResponses
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvshowsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val tvshows: LiveData<LocalResponses<PagedList<TVShowEntity>>> =
        Transformations.switchMap(getDataTVShows()) { getDataTVShows() }

    private fun getDataTVShows(): LiveData<LocalResponses<PagedList<TVShowEntity>>> {
        return repository.getAllRemoteTVShows()
    }

}