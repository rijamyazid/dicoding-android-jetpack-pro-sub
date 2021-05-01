package com.example.jetpack_submissions.ui.detail

import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.MovieEntity

class DetailViewModel: ViewModel() {

    private var movieEntity =
        MovieEntity("", "", "", "", "", "", listOf(), 0)

    fun setMovieEntity(entity: MovieEntity?){
        if (entity != null) {
            movieEntity = entity
        }
    }

    fun getMovieEntity() = movieEntity

}