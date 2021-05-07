package com.example.jetpack_submissions.ui.detail.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.databinding.ActivityMovieDetailBinding
import com.example.jetpack_submissions.ui.detail.GenresAdapter
import com.example.jetpack_submissions.utils.GenreData
import com.example.jetpack_submissions.utils.Helpers

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var genresAdapter: GenresAdapter
    private lateinit var viewModel: MovieDetailViewModel
    private val args: MovieDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.movie_detail)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[MovieDetailViewModel::class.java]
        genresAdapter = GenresAdapter()

        val movie = args.movieItem
        viewModel.setMovieItem(movie)
        viewModel.getMovieItem().observe(this, {
            binding.tvTitleContent.text = it.title
            binding.tvYearContent.text =
                getString(R.string.release_date, Helpers.inverseDate(it.releaseDate))
            binding.tvPopularityContent.text = it.popularity.toString()
            binding.tvVoteCountContent.text = it.voteCount.toString()
            binding.tvVoteContent.text =
                getString(R.string.vote_average_2, it.voteAverage.toString())
            binding.tvDetailDescription.text = it.overview

            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + it.posterPath)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(binding.imgDetailPoster)

            with(binding.rvGenres) {
                layoutManager = GridLayoutManager(context, 3)
                setHasFixedSize(true)
                genresAdapter.setGenres(GenreData.convertMovieGenres(context, it.genreIds))
                adapter = genresAdapter
            }
        })

    }
}