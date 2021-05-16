package com.example.jetpack_submissions.ui.favorite.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.databinding.FragmentMoviesFavoriteBinding
import com.example.jetpack_submissions.ui.favorite.FavoriteFragmentDirections
import com.example.jetpack_submissions.ui.home.movies.MoviesPagingDataAdapter
import com.example.jetpack_submissions.ui.home.movies.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFavoriteFragment : Fragment(), MoviesPagingDataAdapter.MovieListener {

    private val viewModel: MoviesViewModel by activityViewModels()
    private var binding: FragmentMoviesFavoriteBinding? = null
    private lateinit var adapter: MoviesPagingDataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesFavoriteBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            adapter = MoviesPagingDataAdapter(context, this)

            viewModel.favoritedMovies.observe(viewLifecycleOwner, {
                adapter.submitList(it)
                adapter.notifyDataSetChanged()
            })

            with(binding?.rvMovies2) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = adapter
            }

        }

    }

    override fun movieOnClick(entity: MovieEntity) {
        val action = FavoriteFragmentDirections.actionFavoriteFragmentToDetailActivity(entity)
        findNavController().navigate(action)
    }

}