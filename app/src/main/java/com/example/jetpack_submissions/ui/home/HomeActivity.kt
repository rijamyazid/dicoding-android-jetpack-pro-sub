package com.example.jetpack_submissions.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.jetpack_submissions.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}