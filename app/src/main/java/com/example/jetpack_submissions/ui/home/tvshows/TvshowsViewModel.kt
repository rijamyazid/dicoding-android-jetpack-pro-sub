package com.example.jetpack_submissions.ui.home.tvshows

import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.source.Repository

class TvshowsViewModel(private val repository: Repository) : ViewModel() {

    fun getDataTvshows() = repository.getAllRemoteTVShows()

    fun getLoadingStates() = repository.isOnloadingStates

    fun getConnectionStates() = repository.isConnectionSuccessful

}