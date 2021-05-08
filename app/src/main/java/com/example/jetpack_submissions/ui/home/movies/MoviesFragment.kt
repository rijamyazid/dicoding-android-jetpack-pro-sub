package com.example.jetpack_submissions.ui.home.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack_submissions.data.source.remote.response.MovieItem
import com.example.jetpack_submissions.databinding.FragmentMoviesBinding
import com.example.jetpack_submissions.ui.home.HomeFragmentDirections
import com.example.jetpack_submissions.viewmodel.ViewModelFactory

class MoviesFragment : Fragment(), MoviesAdapter.MovieListener {

    lateinit var viewModel: MoviesViewModel
    lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

            val moviesAdapter = MoviesAdapter(context, this)

            viewModel.getAllRemoteMovies().observe(viewLifecycleOwner, {
                moviesAdapter.setMovies(it)
                moviesAdapter.notifyDataSetChanged()
            })

            with(binding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = moviesAdapter
            }
        }
    }

    override fun movieOnClick(entity: MovieItem) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailActivity(entity)
        findNavController().navigate(action)
    }

}