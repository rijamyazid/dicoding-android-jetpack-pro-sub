package com.example.jetpack_submissions.ui.favorite

import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.ui.favorite.movies.MoviesFavoriteFragment
import com.example.jetpack_submissions.ui.favorite.tvshows.TVShowsFavoriteFragment

class FavoritePagerAdapter(private val fragment: Fragment) : FragmentStateAdapter(fragment) {

    companion object {
        @StringRes
        val TAB_TITLES = intArrayOf(R.string.movies, R.string.tvshows)
    }

    override fun getItemCount(): Int = TAB_TITLES.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MoviesFavoriteFragment()
            1 -> TVShowsFavoriteFragment()
            else -> Fragment()
        }
    }

}