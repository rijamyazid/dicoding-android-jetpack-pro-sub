package com.example.jetpack_submissions.ui.detail.tvshow

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.databinding.ActivityTvshowDetailBinding
import com.example.jetpack_submissions.ui.detail.GenresAdapter
import com.example.jetpack_submissions.utils.GenreData
import com.example.jetpack_submissions.utils.Helpers
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TVShowDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTvshowDetailBinding
    private lateinit var genresAdapter: GenresAdapter
    private val viewModel: TVShowDetailViewModel by viewModels()
    private val args: TVShowDetailActivityArgs by navArgs()
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTvshowDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.tvshow_detail)

        genresAdapter = GenresAdapter()

        val tvshow = args.tvshowEntity
        viewModel.setTVShowEntity(tvshow)
        viewModel.tvshowEntity.observe(this, {
            binding.tvTitleContent2.text = it.name
            binding.tvYearContent2.text = getString(
                R.string.release_date,
                Helpers.inverseDate(it.firstAirDate)
            )
            binding.tvPopularityContent2.text = it.popularity
            binding.tvVoteContent2.text =
                getString(R.string.vote_average_2, it.voteAverage)
            binding.tvDetailDescription2.text = it.overview

            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500" + it.posterPath)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(binding.imgDetailPoster2)

            with(binding.rvGenres2) {
                layoutManager = GridLayoutManager(context, 3)
                setHasFixedSize(true)
                genresAdapter.setGenres(GenreData.convertTVShowGenres(context, it.genreIds))
                adapter = genresAdapter
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.app_bar_favorite_menu, menu)
        this.menu = menu

        viewModel.tvshowEntity.observe(this, {
            setFavoriteState(it.favorite)
        })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.appbar_add_to_favorite) {
            viewModel.setTVShowFavoriteStatus()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.appbar_add_to_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_empty)
        }
    }
}