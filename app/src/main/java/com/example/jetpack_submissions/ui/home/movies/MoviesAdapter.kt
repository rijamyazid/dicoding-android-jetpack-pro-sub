package com.example.jetpack_submissions.ui.home.movies

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.data.source.remote.response.MoviesItem
import com.example.jetpack_submissions.databinding.ItemsMoviesBinding

class MoviesAdapter(private val context: Context?, private val listener: MovieListener): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var listMovie = ArrayList<MoviesItem>()

    fun setMovies(movies: ArrayList<MoviesItem>?) {
        if (movies == null) return
        listMovie.clear()
        listMovie.addAll(movies)
    }

    inner class MoviesViewHolder(private val binding: ItemsMoviesBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MoviesItem) {
            with(binding) {
                tvItemTitle.text = context?.getString(
                    R.string.titleAndRelease,
                    movie.originalTitle,
                    movie.releaseDate
                )
                tvItemDesc.text = movie.overview
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500" + movie.posterPath)
                    .into(imgPoster)

                itemView.setOnClickListener {
                    listener.movieOnClick(movie)
                }
            }
        }

    }

    interface MovieListener {
        fun movieOnClick(entity: MoviesItem)
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