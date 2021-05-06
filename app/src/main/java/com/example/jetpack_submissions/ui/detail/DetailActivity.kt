package com.example.jetpack_submissions.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    lateinit var genresAdapter: GenresAdapter
    lateinit var viewModel: DetailViewModel
    val args: DetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setSupportActionBar(binding.toolbarDetail)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]
        genresAdapter = GenresAdapter()

        val movie = args.movie
        viewModel.setMovieEntity(movie)
        val vmMovie = viewModel.getMovieEntity()
        binding.tvTitleContent.text = vmMovie?.title
        binding.tvYearContent.text = getString(R.string.release_year_style2, vmMovie?.releaseYear)
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