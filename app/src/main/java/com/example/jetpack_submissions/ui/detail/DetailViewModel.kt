package com.example.jetpack_submissions.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.source.remote.response.MovieItem

class DetailViewModel: ViewModel() {

    private val _movieEntity = MutableLiveData<MovieItem>()
    val movieEntity: LiveData<MovieItem> = _movieEntity

    fun setMovieEntity(entity: MovieItem) {
        _movieEntity.value = entity
    }

}