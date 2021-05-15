package com.example.jetpack_submissions.ui.home.tvshows

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.databinding.ItemsMoviesBinding
import com.example.jetpack_submissions.utils.Helpers

class TVShowsPagingDataAdapter(
    private val context: Context?,
    private val listener: TVShowListener
) : PagedListAdapter<TVShowEntity, TVShowsPagingDataAdapter.TVShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<TVShowEntity> =
            object : DiffUtil.ItemCallback<TVShowEntity>() {
                override fun areItemsTheSame(
                    oldItem: TVShowEntity,
                    newItem: TVShowEntity
                ): Boolean {
                    return oldItem.name == newItem.name &&
                            oldItem.popularity == newItem.popularity &&
                            oldItem.voteAverage == newItem.voteAverage &&
                            oldItem.overview == newItem.overview &&
                            oldItem.firstAirDate == newItem.firstAirDate &&
                            oldItem.genreIds.size == newItem.genreIds.size
                }

                override fun areContentsTheSame(
                    oldItem: TVShowEntity,
                    newItem: TVShowEntity
                ): Boolean {
                    return oldItem == newItem
                }

            }
    }

    inner class TVShowViewHolder(val binding: ItemsMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tvshowEntity: TVShowEntity) {
            with(binding) {
                tvItemTitle.text = context?.getString(
                    R.string.titleAndRelease,
                    tvshowEntity.name,
                    Helpers.getYearFromDate(tvshowEntity.firstAirDate)
                )
                tvItemDesc.text = tvshowEntity.overview
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500" + tvshowEntity.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)

                itemView.setOnClickListener {
                    listener.tvshowOnClick(tvshowEntity)
                }
            }
        }

    }

    override fun onBindViewHolder(
        holder: TVShowsPagingDataAdapter.TVShowViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position) as TVShowEntity)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TVShowsPagingDataAdapter.TVShowViewHolder {
        val binding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVShowViewHolder(binding)
    }

    interface TVShowListener {
        fun tvshowOnClick(tvshow: TVShowEntity)
    }

}