package com.example.jetpack_submissions.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.data.MovieEntity
import com.example.jetpack_submissions.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.extras
        if (intent != null){
            val movie = intent.getParcelable<MovieEntity>("Movie")
            binding.tvExample.text = movie?.title ?: ""
        }

    }
}