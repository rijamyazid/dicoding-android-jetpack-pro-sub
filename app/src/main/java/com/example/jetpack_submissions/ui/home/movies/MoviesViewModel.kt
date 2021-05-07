package com.example.jetpack_submissions.ui.home.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.source.Repository

class MoviesViewModel(private val repository: Repository) : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getAllRemoteMovies() = repository.getAllRemoteMovies()

    fun setOnLoadingStates(status: Boolean) {
        _isLoading.value = status
    }

}