package com.example.jetpack_submissions.data.source.remote.api

import com.example.jetpack_submissions.data.source.remote.response.MovieResponse
import com.example.jetpack_submissions.data.source.remote.response.TVShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/popular")
    fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String
    ): Call<MovieResponse>

    @GET("3/tv/popular")
    fun getTVShows(
        @Query("api_key") apiKey: String,
        @Query("language") language: String,
        @Query("page") page: String
    ): Call<TVShowResponse>

}