package com.example.jetpack_submissions.ui.home.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack_submissions.data.source.local.LocalStatus
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.databinding.FragmentTvshowsBinding
import com.example.jetpack_submissions.ui.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TvshowsFragment : Fragment(), TvshowsAdapter.TVShowListener {

    private lateinit var binding: FragmentTvshowsBinding
    private val viewModel: TvshowsViewModel by viewModels()
    private lateinit var tvShowsAdapter: TVShowsPagingDataAdapter

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
            tvShowsAdapter = TVShowsPagingDataAdapter(context, this)

            viewModel.getDataTVShows().observe(viewLifecycleOwner, {
                if (it != null) {
                    when (it.status) {
                        LocalStatus.LOADING -> {
                        }
                        LocalStatus.SUCCESS -> {
                            tvShowsAdapter.submitList(it.data)
                        }
                        LocalStatus.ERROR -> {
                        }
                    }
                }
            })

            with(binding.rvTvshows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowsAdapter
            }

        }
    }

    override fun tvshowOnClick(tvshow: TVShowEntity) {
        val action = HomeFragmentDirections.actionHomeFragmentToTVShowDetailActivity(tvshow)
        findNavController().navigate(action)

    }

}