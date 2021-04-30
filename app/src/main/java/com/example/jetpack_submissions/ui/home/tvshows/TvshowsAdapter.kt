package com.example.jetpack_submissions.ui.home.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpack_submissions.data.TvshowEntity
import com.example.jetpack_submissions.databinding.FragmentTvshowsBinding
import com.example.jetpack_submissions.databinding.ItemsTvshowsBinding

class TvshowsAdapter: RecyclerView.Adapter<TvshowsAdapter.TvshowsViewHolder>() {

    private var listTvshows = ArrayList<TvshowEntity>()

    fun setTvshows(tvShows: ArrayList<TvshowEntity>?){
        if (tvShows == null) return
        listTvshows.clear()
        listTvshows.addAll(tvShows)
    }

    inner class TvshowsViewHolder(private val binding: ItemsTvshowsBinding)
        : RecyclerView.ViewHolder(binding.root){
            fun bind(tvShow: TvshowEntity){
                with(binding){
                    tvItemTitle.text = tvShow.title
                    tvItemDesc.text = tvShow.desc
                    Glide.with(itemView.context)
                        .load(tvShow.imgPath)
                        .into(imgPoster)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvshowsViewHolder {
        val binding = ItemsTvshowsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvshowsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvshowsViewHolder, position: Int) {
        val tvShow = listTvshows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount() = listTvshows.size

}