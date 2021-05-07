package com.example.jetpack_submissions.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.data.source.remote.response.TVShowItem

class TVShowDetailViewModel : ViewModel() {

    private val _tvshowItem = MutableLiveData<TVShowItem>()

    fun getTVShowItem(): LiveData<TVShowItem> = _tvshowItem

    fun setTVShowItem(tvshowItem: TVShowItem) {
        _tvshowItem.value = tvshowItem
    }

}