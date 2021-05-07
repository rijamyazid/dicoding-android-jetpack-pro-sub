package com.example.jetpack_submissions.ui.home.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.ConnectionStatus
import com.example.jetpack_submissions.data.source.Repository

class TvshowsViewModel(private val repository: Repository) : ViewModel() {

    private val _loadingStates = MutableLiveData<Boolean>()
    private val _connectionStates = MutableLiveData<ConnectionStatus>()

    fun getDataTvshows() = repository.getAllRemoteTVShows()

    fun getLoadingStates(): LiveData<Boolean> = _loadingStates

    fun getConnectionStates(): LiveData<ConnectionStatus> = _connectionStates

    fun setLoadingStates(status: Boolean) {
        _loadingStates.value = status
    }

    fun setConnectionStates(status: ConnectionStatus) {
        _connectionStates.value = status
    }

}