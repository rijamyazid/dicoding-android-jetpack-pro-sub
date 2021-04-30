package com.example.jetpack_submissions.ui.home.movies

import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.utils.DataDummy

class MoviesViewModel: ViewModel() {

    fun getDataMovies() = DataDummy.generateDummyMovies()

}