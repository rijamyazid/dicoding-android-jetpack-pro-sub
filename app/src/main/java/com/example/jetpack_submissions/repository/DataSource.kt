package com.example.jetpack_submissions.repository

import androidx.lifecycle.LiveData
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity

interface DataSource {

    fun getAllRemoteMovies(): LiveData<List<MovieEntity>>

    fun getAllRemoteTVShows(): LiveData<List<TVShowEntity>>

}