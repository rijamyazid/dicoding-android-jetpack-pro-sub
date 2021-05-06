package com.example.jetpack_submissions.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var genresAdapter: GenresAdapter
    private lateinit var viewModel: DetailViewModel
    private val args: DetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.detail)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]
        genresAdapter = GenresAdapter()

        val movie = args.movieItem
        viewModel.setMovieEntity(movie)
        viewModel.movieEntity.observe(this, {
            binding.tvTitleContent.text = it.originalTitle
            binding.tvYearContent.text = getString(R.string.release_year_style2, it.releaseDate)
            binding.tvCountryContent.text = it.originalLanguage
            binding.tvDirectorContent.text = it.popularity.toString()
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
                genresAdapter.setGenres(it.genreIds)
                adapter = genresAdapter
            }
        })

    }
}