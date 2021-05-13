package com.example.jetpack_submissions.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity

class MovieDetailViewModel : ViewModel() {

    private val _movieEntity = MutableLiveData<MovieEntity>()

    fun getMovieItem(): LiveData<MovieEntity> = _movieEntity

    fun setMovieItem(movieItem: MovieEntity) {
        _movieEntity.value = movieItem
    }

}