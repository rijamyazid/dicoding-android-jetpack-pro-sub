package com.example.jetpack_submissions.ui.home.tvshows

import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TvshowsViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getDataTvshows() = repository.getAllRemoteTVShows()

}