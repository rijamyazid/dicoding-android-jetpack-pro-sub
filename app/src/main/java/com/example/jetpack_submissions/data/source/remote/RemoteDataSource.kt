package com.example.jetpack_submissions.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem
import com.example.jetpack_submissions.utils.JsonHelper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val jsonHelper: JsonHelper) {

    fun getAllRemoteMovies(): LiveData<RemoteResponses<List<MovieItem>>> {
        val result = MutableLiveData<RemoteResponses<List<MovieItem>>>()
        result.value = RemoteResponses.success(jsonHelper.loadRemoteMovies())
        return result
    }

    fun getAllRemoteTVShows(): LiveData<RemoteResponses<List<TVShowItem>>> {
        val result = MutableLiveData<RemoteResponses<List<TVShowItem>>>()
        result.value = RemoteResponses.success(jsonHelper.loadRemoteTVShows())
        return result
    }

}