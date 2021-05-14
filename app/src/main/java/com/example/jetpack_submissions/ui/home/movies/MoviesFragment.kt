package com.example.jetpack_submissions.ui.home.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack_submissions.data.source.local.LocalStatus
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.databinding.FragmentMoviesBinding
import com.example.jetpack_submissions.ui.home.HomeFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment(), MoviesAdapter.MovieListener {

    private val viewModel: MoviesViewModel by viewModels()
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var moviesAdapter: MoviesPagingDataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("FRAGMENT_POS", "Movie: OnViewCreated")

        if (activity != null) {
            moviesAdapter = MoviesPagingDataAdapter(context, this)

            viewModel.getDataMovies().observe(viewLifecycleOwner, {
                if (it != null) {
                    when (it.status) {
                        LocalStatus.LOADING -> {
                        }
                        LocalStatus.SUCCESS -> {
                            moviesAdapter.submitList(it.data)
                            moviesAdapter.notifyDataSetChanged()
                        }
                        LocalStatus.ERROR -> {
                        }
                    }
                }
            })

            with(binding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = moviesAdapter
            }
        }
    }

    override fun onStart() {
        super.onStart()

        Log.d("FRAGMENT_POS", "Movie: OnStart")
    }

    override fun onResume() {
        super.onResume()

        Log.d("FRAGMENT_POS", "Movie: OnResume")
    }

    override fun onPause() {
        super.onPause()

        Log.d("FRAGMENT_POS", "Movie: OnPause")
    }

    override fun onStop() {
        super.onStop()

        Log.d("FRAGMENT_POS", "Movie: OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("FRAGMENT_POS", "Movie: OnDestroy")
    }

    override fun movieOnClick(entity: MovieEntity) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailActivity(entity)
        findNavController().navigate(action)
    }

}