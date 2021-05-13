package com.example.jetpack_submissions.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity

class TVShowDetailViewModel : ViewModel() {

    private val _tvshowItem = MutableLiveData<TVShowEntity>()

    fun getTVShowItem(): LiveData<TVShowEntity> = _tvshowItem

    fun setTVShowItem(tvshowItem: TVShowEntity) {
        _tvshowItem.value = tvshowItem
    }

}