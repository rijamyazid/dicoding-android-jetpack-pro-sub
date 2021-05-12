package com.example.jetpack_submissions.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity

@Dao
interface TVShowDao {

    @Insert
    fun insertTVShows(vararg tvshows: TVShowEntity)

    @Update
    fun updateTVShow(tvshow: TVShowEntity)

    @Query("UPDATE tvshowentity SET tvshow_isBookmarked = :status WHERE tvshow_id = :tvshowId")
    fun updateBookmarkStatus(status: Boolean, tvshowId: String)

    @Query("SELECT * FROM tvshowentity")
    fun getAllTVShows(): LiveData<List<TVShowEntity>>

    @Query("SELECT * FROM tvshowentity ORDER BY tvshow_title ASC")
    fun getAllTVShowsSortedByName(): LiveData<List<TVShowEntity>>

}