package com.example.jetpack_submissions.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpack_submissions.R
import com.example.jetpack_submissions.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle(R.string.home)
    }

}