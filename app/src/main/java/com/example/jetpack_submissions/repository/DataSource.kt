package com.example.jetpack_submissions.repository

import androidx.lifecycle.LiveData
import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem

interface DataSource {

    fun getAllRemoteMovies(): LiveData<ArrayList<MovieItem>>

    fun getAllRemoteTVShows(): LiveData<ArrayList<TVShowItem>>

}