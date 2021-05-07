package com.example.jetpack_submissions.ui.home.movies

import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.source.Repository

class MoviesViewModel(private val repository: Repository) : ViewModel() {

    fun getAllRemoteMovies() = repository.getAllRemoteMovies()

    fun getLoadingStates() = repository.isOnloadingStates

    fun getConnectionStates() = repository.isConnectionSuccessful

}