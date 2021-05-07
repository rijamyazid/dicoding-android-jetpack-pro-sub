package com.example.jetpack_submissions.ui.home.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.ConnectionStatus
import com.example.jetpack_submissions.data.source.Repository
import com.example.jetpack_submissions.data.source.remote.response.MovieItem

class MoviesViewModel(private val repository: Repository) : ViewModel() {

    private val _loadingStates = MutableLiveData<Boolean>()
    private val _connectionStates = MutableLiveData<ConnectionStatus>()

    private var _tempRemoteMovies = MutableLiveData<ArrayList<MovieItem>>()

    fun getAllRemoteMovies() = repository.getAllRemoteMovies()

    fun getLoadingStates(): LiveData<Boolean> = _loadingStates

    fun getConnectionStates(): LiveData<ConnectionStatus> = _connectionStates

    fun getTempRemoteMovies() = _tempRemoteMovies

    fun setLoadingStates(status: Boolean) {
        _loadingStates.value = status
    }

    fun setConnectionStates(status: ConnectionStatus) {
        _connectionStates.value = status
    }

}