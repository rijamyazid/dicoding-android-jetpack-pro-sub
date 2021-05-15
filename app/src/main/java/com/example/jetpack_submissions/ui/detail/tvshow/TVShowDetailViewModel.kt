package com.example.jetpack_submissions.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TVShowDetailViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _tvshow = MutableLiveData<TVShowEntity>()

    val tvshowEntity: LiveData<TVShowEntity> = Transformations.switchMap(_tvshow) {
        repository.getTVShowById(it.id)
    }

    fun setTVShowEntity(tvshowEntity: TVShowEntity) {
        _tvshow.value = tvshowEntity
    }

    fun setTVShowFavoriteStatus() {
        val tvshow = tvshowEntity.value
        if (tvshow != null) {
            val tvshowId = tvshow.id
            val tvshowStatus = tvshow.favorite
            repository.setTVShowFavoriteStatus(!tvshowStatus, tvshowId)
        }
    }

}