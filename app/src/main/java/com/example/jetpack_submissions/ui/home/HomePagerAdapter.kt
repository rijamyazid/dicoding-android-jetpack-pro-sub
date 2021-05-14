package com.example.jetpack_submissions.ui.home

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.ui.home.movies.MoviesFragment
import com.example.jetpack_submissions.ui.home.tvshows.TvshowsFragment

class HomePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    companion object {
        @StringRes
        val TAB_TITLES = intArrayOf(R.string.movies, R.string.tvshows)
    }

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MoviesFragment()
            1 -> TvshowsFragment()
            else -> Fragment()
        }
    }

}