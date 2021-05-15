package com.example.jetpack_submissions.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.databinding.FragmentFavoriteBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private var binding: FragmentFavoriteBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title =
            resources.getString(R.string.appbar_favorite)

        if (binding != null) {
            val favoritePagerAdapter = FavoritePagerAdapter(this)
            binding!!.viewPager2.adapter = favoritePagerAdapter
            TabLayoutMediator(binding!!.tabs2, binding!!.viewPager2) { tab, position ->
                tab.text = resources.getString(FavoritePagerAdapter.TAB_TITLES[position])
            }.attach()
        }
    }

}