package com.example.jetpack_submissions.ui.detail.tvshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.databinding.ActivityTvshowDetailBinding
import com.example.jetpack_submissions.ui.detail.GenresAdapter
import com.example.jetpack_submissions.utils.GenreData
import com.example.jetpack_submissions.utils.Helpers

class TVShowDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvshowDetailBinding
    private lateinit var genresAdapter: GenresAdapter
    private lateinit var viewModel: TVShowDetailViewModel
    private val args: TVShowDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTvshowDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.tvshow_detail)

        genresAdapter = GenresAdapter()
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[TVShowDetailViewModel::class.java]

        val tvshow = args.tvshowItem
        viewModel.setTVShowEntity(tvshow)
        viewModel.tvshowEntity.observe(this, {
            binding.tvTitleContent.text = it.name
            binding.tvYearContent.text = getString(
                R.string.release_date,
                Helpers.inverseDate(it.firstAirDate)
            )
            binding.tvPopularityContent.text = it.popularity.toString()
            binding.tvVoteContent.text =
                getString(R.string.vote_average_2, it.voteAverage.toString())
            binding.tvVoteCountContent.text = it.voteCount.toString()
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
                genresAdapter.setGenres(GenreData.convertTVShowGenres(context, it.genreIds))
                adapter = genresAdapter
            }
        })

    }
}