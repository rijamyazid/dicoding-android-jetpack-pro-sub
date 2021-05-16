package com.example.jetpack_submissions.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity

@Dao
interface TVShowDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTVShows(tvshows: List<TVShowEntity>)

    @Update
    fun updateTVShow(tvshow: TVShowEntity)

    @Query("UPDATE tvshowentity SET tvshow_isFavorite = :status WHERE tvshow_id = :tvshowId")
    fun setTVShowFavoriteStatus(status: Boolean, tvshowId: String)

    @Query("SELECT * FROM tvshowentity WHERE tvshow_id=:tvshowId")
    fun getTVShowById(tvshowId: String): LiveData<TVShowEntity>

    @Query("SELECT * FROM tvshowentity")
    fun getAllTVShows(): DataSource.Factory<Int, TVShowEntity>

    @Query("SELECT * FROM tvshowentity WHERE tvshow_isFavorite = 1")
    fun getAllFavoriteTVShows(): DataSource.Factory<Int, TVShowEntity>

    @Query("SELECT * FROM tvshowentity ORDER BY tvshow_title ASC")
    fun getAllTVShowsSortedByName(): LiveData<List<TVShowEntity>>

}