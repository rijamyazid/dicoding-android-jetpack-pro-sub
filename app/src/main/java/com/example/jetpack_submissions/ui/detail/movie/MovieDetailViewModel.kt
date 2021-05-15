package com.example.jetpack_submissions.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _movie = MutableLiveData<MovieEntity>()

    val movieEntity: LiveData<MovieEntity> = Transformations.switchMap(_movie) {
        repository.getMovieById(it.id)
    }

    fun setMovieEntity(movieItem: MovieEntity) {
        _movie.value = movieItem
    }

    fun setMovieFavoriteStatus() {
        val movie = movieEntity.value
        if (movie != null) {
            val movieStatus = movie.favorite
            val movieId = movie.id
            repository.setMovieFavoriteStatus(!movieStatus, movieId)
        }
    }

}