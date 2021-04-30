package com.example.jetpack_submissions.ui.home.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpack_submissions.data.MovieEntity
import com.example.jetpack_submissions.databinding.ItemsMoviesBinding

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var listMovie = ArrayList<MovieEntity>()

    fun setMovies(movies: ArrayList<MovieEntity>?) {
        if (movies == null) return
        listMovie.clear()
        listMovie.addAll(movies)
    }

    inner class MoviesViewHolder(private val binding: ItemsMoviesBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieEntity){
            with(binding){
                tvItemTitle.text = movie.title
                tvItemDesc.text = movie.desc
                Glide.with(itemView.context)
                    .load(movie.imgPath)
                    .into(imgPoster)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ItemsMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size

}