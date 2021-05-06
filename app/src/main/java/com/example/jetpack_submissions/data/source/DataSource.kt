package com.example.jetpack_submissions.data.source

import androidx.lifecycle.LiveData
import com.example.jetpack_submissions.data.source.remote.response.MoviesItem

interface DataSource {

    fun getAllRemoteMovies(): LiveData<ArrayList<MoviesItem>>

}