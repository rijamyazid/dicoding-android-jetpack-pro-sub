package com.example.jetpack_submissions.ui.home.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.source.local.LocalResponses
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val movies: LiveData<LocalResponses<List<MovieEntity>>> =
        Transformations.switchMap(getDataMovies()) { getDataMovies() }

    private fun getDataMovies(): LiveData<LocalResponses<List<MovieEntity>>> {
        return repository.getAllRemoteMovies()
    }

}