package com.example.jetpack_submissions.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.data.MovieEntity
import com.example.jetpack_submissions.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    lateinit var genresAdapter: GenresAdapter
    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        genresAdapter = GenresAdapter()

        val intent = intent.extras
        if (intent != null){
            val movie = intent.getParcelable<MovieEntity>("Movie")
            viewModel.setMovieEntity(movie)
            val vmMovie = viewModel.getMovieEntity()
            binding.tvDetailTitleContent.text = vmMovie?.title
            binding.tvYearContent.text = vmMovie?.releaseYear
            binding.tvCountryContent.text = vmMovie?.country
            binding.tvDirectorContent.text = vmMovie?.director
            binding.tvDetailDescription.text = vmMovie?.desc

            Glide.with(this)
                    .load(vmMovie?.imgPath)
                    .into(binding.imgDetailPoster)

            with(binding.rvGenres){
                layoutManager = GridLayoutManager(context, 3)
                setHasFixedSize(true)
                genresAdapter.setGenres(vmMovie?.genre)
                adapter = genresAdapter
            }
        }

    }
}