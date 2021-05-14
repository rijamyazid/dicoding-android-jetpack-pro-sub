package com.example.jetpack_submissions.ui.home.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.data.source.local.entity.MovieEntity
import com.example.jetpack_submissions.databinding.ItemsMoviesBinding
import com.example.jetpack_submissions.utils.Helpers

class MoviesPagingDataAdapter(
    private val context: Context?,
    private val listener: MoviesAdapter.MovieListener
) : PagedListAdapter<MovieEntity, MoviesPagingDataAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<MovieEntity> =
            object : DiffUtil.ItemCallback<MovieEntity>() {
                override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                    return oldItem.title == newItem.title &&
                            oldItem.popularity == newItem.popularity &&
                            oldItem.voteAverage == newItem.voteAverage &&
                            oldItem.overview == newItem.overview &&
                            oldItem.releaseDate == newItem.releaseDate &&
                            oldItem.genreIds.size == newItem.genreIds.size
                }

                override fun areContentsTheSame(
                    oldItem: MovieEntity,
                    newItem: MovieEntity
                ): Boolean {
                    return oldItem == newItem
                }

            }
    }

    inner class MovieViewHolder(val binding: ItemsMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieEntity: MovieEntity) {
            with(binding) {
                tvItemTitle.text = context?.getString(
                    R.string.titleAndRelease,
                    movieEntity.title,
                    Helpers.getYearFromDate(movieEntity.releaseDate)
                )
                tvItemDesc.text = movieEntity.overview
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500" + movieEntity.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)

                itemView.setOnClickListener {
                    listener.movieOnClick(movieEntity)
                }
            }
        }

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position) as MovieEntity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

}