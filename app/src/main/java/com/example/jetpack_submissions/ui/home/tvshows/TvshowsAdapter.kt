package com.example.jetpack_submissions.ui.home.tvshows

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.data.MovieEntity
import com.example.jetpack_submissions.databinding.ItemsMoviesBinding
import com.example.jetpack_submissions.ui.home.MovieListener

class TvshowsAdapter(val context: Context?, val listener: MovieListener): RecyclerView.Adapter<TvshowsAdapter.TvshowsViewHolder>() {

    private var listTvshows = ArrayList<MovieEntity>()

    fun setTvshows(tvShows: ArrayList<MovieEntity>?){
        if (tvShows == null) return
        listTvshows.clear()
        listTvshows.addAll(tvShows)
    }

    inner class TvshowsViewHolder(private val binding: ItemsMoviesBinding)
        : RecyclerView.ViewHolder(binding.root){
            fun bind(tvShow: MovieEntity){
                with(binding){
                    tvItemTitle.text = context?.getString(R.string.titleAndRelease, tvShow.title, tvShow.releaseYear)
                    tvItemDesc.text = tvShow.desc
                    Glide.with(itemView.context)
                        .load(tvShow.imgPath)
                        .into(imgPoster)

                    itemView.setOnClickListener {
                        listener.movieOnClick(tvShow)
                    }
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvshowsViewHolder {
        val binding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvshowsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvshowsViewHolder, position: Int) {
        val tvShow = listTvshows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount() = listTvshows.size

}