package com.example.jetpack_submissions.ui.home.tvshows

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.data.source.local.entity.TVShowEntity
import com.example.jetpack_submissions.databinding.ItemsMoviesBinding
import com.example.jetpack_submissions.utils.Helpers

class TvshowsAdapter(val context: Context?, val listener: TVShowListener) :
    RecyclerView.Adapter<TvshowsAdapter.TVshowsViewHolder>() {

    private var listTvshows = ArrayList<TVShowEntity>()

    fun setTvshows(tvShows: List<TVShowEntity>?) {
        if (tvShows == null) return
        listTvshows.clear()
        listTvshows.addAll(tvShows)
    }

    inner class TVshowsViewHolder(private val binding: ItemsMoviesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TVShowEntity) {
            with(binding) {
                tvItemTitle.text =
                    context?.getString(
                        R.string.titleAndRelease,
                        tvShow.name,
                        Helpers.getYearFromDate(tvShow.firstAirDate)
                    )
                tvItemDesc.text = tvShow.overview
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500" + tvShow.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)

                itemView.setOnClickListener {
                    listener.tvshowOnClick(tvShow)
                }
            }
        }
    }

    interface TVShowListener {
        fun tvshowOnClick(tvshow: TVShowEntity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVshowsViewHolder {
        val binding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TVshowsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TVshowsViewHolder, position: Int) {
        val tvShow = listTvshows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount() = listTvshows.size

}