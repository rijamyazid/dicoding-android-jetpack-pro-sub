package com.example.jetpack_submissions.ui.home

import com.example.jetpack_submissions.data.MovieEntity

interface MovieListener {
    fun movieOnClick(entity: MovieEntity)
}