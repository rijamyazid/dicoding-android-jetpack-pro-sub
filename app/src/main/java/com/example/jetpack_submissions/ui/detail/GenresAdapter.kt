package com.example.jetpack_submissions.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack_submissions.databinding.ItemsGenreBinding

class GenresAdapter: RecyclerView.Adapter<GenresAdapter.GenresViewHolder>() {

    var listGenre = listOf<String>()

    fun setGenres(genres: List<Int>?) {
        if (genres == null) return
        val genre_str = arrayListOf<String>()
        for (genre in genres) {
            genre_str.add(genre.toString())
        }
        listGenre = genre_str
    }

    inner class GenresViewHolder(val binding: ItemsGenreBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(genre: String){
            with(binding){
                tvGenre.text = genre
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val binding = ItemsGenreBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GenresViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        val genre = listGenre[position]
        holder.bind(genre)
    }

    override fun getItemCount() = listGenre.size

}