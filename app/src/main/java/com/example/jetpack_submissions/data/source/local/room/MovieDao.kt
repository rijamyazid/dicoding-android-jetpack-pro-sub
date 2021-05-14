package com.example.jetpack_submissions.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Query("UPDATE movieentity SET movie_isBookmarked = :status WHERE movie_id = :movieId")
    fun updateBookmarkStatus(status: Boolean, movieId: String)

    @Query("SELECT * FROM movieentity")
    fun getAllMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentity ORDER BY movie_title ASC")
    fun getAllMoviesSortedByName(): LiveData<List<MovieEntity>>
}