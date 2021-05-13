package com.example.jetpack_submissions.utils

import android.content.Context
import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JsonHelper @Inject constructor(private val context: Context) {

    fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    fun loadRemoteMovies(): ArrayList<MovieItem> {
        val list = ArrayList<MovieItem>()

        try {
            val responseObject = JSONObject(parsingFileToString("RemoteMoviesData.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val adult = movie.getBoolean("adult")
                val backdropPath = movie.getString("backdrop_path")

                val genreIds = arrayListOf<Int>()
                val genres = movie.getJSONArray("genre_ids")
                for (j in 0 until genres.length()) {
                    genreIds.add(genres.getInt(j))
                }

                val id = movie.getInt("id")
                val originalLanguage = movie.getString("original_language")
                val originalTitle = movie.getString("original_title")
                val overview = movie.getString("overview")
                val popularity = movie.getDouble("popularity")
                val posterPath = movie.getString("poster_path")
                val releaseDate = movie.getString("release_date")
                val title = movie.getString("title")
                val video = movie.getBoolean("video")
                val voteAverage = movie.getDouble("vote_average")
                val voteCount = movie.getInt("vote_count")

                val movieItem = MovieItem(
                    adult, backdropPath,
                    genreIds, id,
                    originalLanguage, originalTitle,
                    overview, popularity,
                    posterPath, releaseDate,
                    title, video,
                    voteAverage,
                    voteCount
                )
                list.add(movieItem)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadRemoteTVShows(): ArrayList<TVShowItem> {
        val list = ArrayList<TVShowItem>()

        try {
            val responseObject =
                JSONObject(parsingFileToString("RemoteTVShowsData.json").toString())
            val listArray = responseObject.getJSONArray("results")
            for (i in 0 until listArray.length()) {
                val tvshow = listArray.getJSONObject(i)

                val firstAirDate = tvshow.getString("first_air_date")
                val overview = tvshow.getString("overview")
                val originalLanguage = tvshow.getString("original_language")
                val genreIds = arrayListOf<Int>()
                val genres = tvshow.getJSONArray("genre_ids")
                for (j in 0 until genres.length()) {
                    genreIds.add(genres.getInt(j))
                }
                val posterPath = tvshow.getString("poster_path")
                val originCountry = arrayListOf<String>()
                val country = tvshow.getJSONArray("origin_country")
                for (k in 0 until country.length()) {
                    originCountry.add(country.getString(k))
                }
                val backdropPath = tvshow.getString("backdrop_path")
                val originalName = tvshow.getString("original_name")
                val popularity = tvshow.getDouble("popularity")
                val voteAverage = tvshow.getDouble("vote_average")
                val name = tvshow.getString("name")
                val id = tvshow.getInt("id")
                val voteCount = tvshow.getInt("vote_count")

                val tvshowItem = TVShowItem(
                    backdropPath, firstAirDate,
                    genreIds, id,
                    name, originCountry,
                    originalLanguage, originalName,
                    overview, popularity, posterPath,
                    voteAverage, voteCount
                )
                list.add(tvshowItem)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

}