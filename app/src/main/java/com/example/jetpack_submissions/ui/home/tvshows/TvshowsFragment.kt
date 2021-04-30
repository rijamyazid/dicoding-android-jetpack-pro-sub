package com.example.jetpack_submissions.ui.home.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.databinding.FragmentTvshowsBinding

class TvshowsFragment : Fragment() {

    lateinit var binding: FragmentTvshowsBinding
    lateinit var viewModel: TvshowsViewModel

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle? ): View? {
        binding = FragmentTvshowsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(activity != null) {
            viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[TvshowsViewModel::class.java]
            val tvShows = viewModel.getDataTvshows()

            val tvShowsAdapter = TvshowsAdapter()
            tvShowsAdapter.setTvshows(tvShows)
            with(binding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowsAdapter
            }
        }
    }

}