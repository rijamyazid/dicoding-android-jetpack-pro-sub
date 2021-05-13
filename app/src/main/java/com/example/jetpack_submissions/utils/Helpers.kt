package com.example.jetpack_submissions.utils

import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem

object Helpers {

    fun getYearFromDate(date: String): String {
        return date.split('-')[0]
    }

    fun inverseDate(date: String): String {
        return date.split('-').reversed().joinToString(separator = "-")
    }

    fun convertMoviesResponsesToEntities(moviesResponses: List<MovieItem>): List<MovieEntity> {
        val moviesEntities = arrayListOf<MovieEntity>()
        for (movie in moviesResponses) {
            val movieEntity = MovieEntity(
                movie.adult,
                movie.backdropPath,
                convertIntToStringList(movie.genreIds),
                movie.id.toString(),
                movie.originalLanguage,
                movie.originalTitle,
                movie.overview,
                movie.popularity.toString(),
                movie.posterPath,
                movie.releaseDate,
                movie.title,
                movie.video,
                movie.voteAverage.toString(),
                movie.voteCount.toString()
            )
            moviesEntities.add(movieEntity)
        }
        return moviesEntities
    }

    fun convertTVShowsResponsesToEntities(tvshowsResponses: List<TVShowItem>): List<TVShowEntity> {
        val tvshowsEntities = arrayListOf<TVShowEntity>()
        for (tvshow in tvshowsResponses) {
            val tvshowEntity = TVShowEntity(
                tvshow.backdropPath,
                tvshow.firstAirDate,
                convertIntToStringList(tvshow.genreIds),
                tvshow.id.toString(),
                tvshow.name,
                tvshow.originCountry,
                tvshow.originalLanguage,
                tvshow.originalName,
                tvshow.overview,
                tvshow.popularity.toString(),
                tvshow.posterPath,
                tvshow.voteAverage.toString(),
                tvshow.voteCount.toString()
            )
            tvshowsEntities.add(tvshowEntity)
        }
        return tvshowsEntities
    }

    private fun convertIntToStringList(intList: List<Int>): List<String> {
        return intList.map { it.toString() }
    }

}