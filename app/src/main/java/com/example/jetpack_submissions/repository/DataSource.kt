package com.example.jetpack_submissions.repository

import androidx.lifecycle.LiveData
import com.example.jetpack_submissions.data.source.local.LocalResponses
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity

interface DataSource {

    fun getAllRemoteMovies(): LiveData<LocalResponses<List<MovieEntity>>>

    fun getAllRemoteTVShows(): LiveData<LocalResponses<List<TVShowEntity>>>

}