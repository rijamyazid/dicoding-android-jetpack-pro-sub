package com.example.jetpack_submissions.ui.favorite.tvshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.databinding.FragmentTvshowsFavoriteBinding
import com.example.jetpack_submissions.ui.favorite.FavoriteFragmentDirections
import com.example.jetpack_submissions.ui.home.tvshows.TVShowsPagingDataAdapter
import com.example.jetpack_submissions.ui.home.tvshows.TvshowsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TVShowsFavoriteFragment : Fragment(), TVShowsPagingDataAdapter.TVShowListener {

    private val viewModel: TvshowsViewModel by activityViewModels()
    private var binding: FragmentTvshowsFavoriteBinding? = null
    private lateinit var adapter: TVShowsPagingDataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvshowsFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (binding != null) {
            adapter = TVShowsPagingDataAdapter(context, this)

            viewModel.favoritedTVShow.observe(viewLifecycleOwner, {
                adapter.submitList(it)
                adapter.notifyDataSetChanged()
            })

            with(binding?.rvTvshows2) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = adapter
            }
        }

    }

    override fun tvshowOnClick(tvshow: TVShowEntity) {
        val action = FavoriteFragmentDirections.actionFavoriteFragmentToTVShowDetailActivity(tvshow)
        findNavController().navigate(action)
    }

}