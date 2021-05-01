package com.example.jetpack_submissions.ui.home.tvshows

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.data.MovieEntity
import com.example.jetpack_submissions.databinding.FragmentTvshowsBinding
import com.example.jetpack_submissions.ui.detail.DetailActivity
import com.example.jetpack_submissions.ui.home.MovieListener

class TvshowsFragment : Fragment(), MovieListener {

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

            val tvShowsAdapter = TvshowsAdapter(context, this)
            tvShowsAdapter.setTvshows(tvShows)
            with(binding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowsAdapter
            }
        }
    }

    override fun movieOnClick(entity: MovieEntity) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra("Movie", entity)
        startActivity(intent)
    }

}