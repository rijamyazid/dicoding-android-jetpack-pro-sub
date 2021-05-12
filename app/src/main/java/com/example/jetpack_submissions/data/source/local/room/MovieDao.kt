package com.example.jetpack_submissions.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity

@Dao
interface MovieDao {

    @Insert
    fun insertMovies(vararg movies: MovieEntity)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("UPDATE movieentity SET movie_isBookmarked = :status WHERE movie_id = :movieId")
    fun updateBookmarkStatus(status: Boolean, movieId: String)

    @Query("SELECT * FROM movieentity")
    fun getAllMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movieentity ORDER BY movie_title ASC")
    fun getAllMoviesSortedByName(): LiveData<List<MovieEntity>>
}