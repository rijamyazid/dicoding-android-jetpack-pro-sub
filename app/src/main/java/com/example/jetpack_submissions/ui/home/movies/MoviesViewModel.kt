package com.example.jetpack_submissions.ui.home.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.jetpack_submissions.data.source.local.LocalResponses
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    val movies: LiveData<LocalResponses<PagedList<MovieEntity>>> =
        Transformations.switchMap(getDataMovies()) { getDataMovies() }

    val favoritedMovies: LiveData<List<MovieEntity>> =
        Transformations.switchMap(getDataFavoriteMovies()) { getDataFavoriteMovies() }

    private fun getDataMovies(): LiveData<LocalResponses<PagedList<MovieEntity>>> {
        return repository.getAllRemoteMovies()
    }

    private fun getDataFavoriteMovies(): LiveData<List<MovieEntity>> {
        return repository.getAllFavoriteMovies()
    }

}