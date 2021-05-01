package com.example.jetpack_submissions.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.show()

        // Memasang ViewPager di Activity
        val homePagerAdapter = HomePagerAdapter(view.context, requireActivity().supportFragmentManager)
        binding.viewPager.adapter = homePagerAdapter
        binding.tabs.setupWithViewPager(binding.viewPager)

    }

}