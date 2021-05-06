package com.example.jetpack_submissions.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem

class TVShowDetailViewModel : ViewModel() {

    private val _tvshowEntity = MutableLiveData<TVShowItem>()
    val tvshowEntity: LiveData<TVShowItem> = _tvshowEntity

    fun setTVShowEntity(entity: TVShowItem) {
        _tvshowEntity.value = entity
    }

}