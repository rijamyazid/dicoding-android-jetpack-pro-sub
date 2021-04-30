package com.example.jetpack_submissions.ui.home.tvshows

import androidx.lifecycle.ViewModel
import com.example.jetpack_submissions.utils.DataDummy

class TvshowsViewModel: ViewModel() {

    fun getDataTvshows() = DataDummy.generateDummyTvshows()

}