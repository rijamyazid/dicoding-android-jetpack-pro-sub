package com.example.jetpack_submissions.ui.home.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack_submissions.data.MovieEntity
import com.example.jetpack_submissions.databinding.FragmentTvshowsBinding
import com.example.jetpack_submissions.ui.home.HomeFragmentDirections
import com.example.jetpack_submissions.ui.home.MovieListener

class TvshowsFragment : Fragment(), MovieListener {

    lateinit var binding: FragmentTvshowsBinding
    lateinit var viewModel: TvshowsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvshowsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[TvshowsViewModel::class.java]
            val tvShows = viewModel.getDataTvshows()

            val tvShowsAdapter = TvshowsAdapter(context, this)
            tvShowsAdapter.setTvshows(tvShows)
            with(binding.rvTvshows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowsAdapter
            }
        }
    }

    override fun movieOnClick(entity: MovieEntity) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailActivity(entity)
        findNavController().navigate(action)
    }

}