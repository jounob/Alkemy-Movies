package com.estherobei.jounmovie.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.estherobei.jounmovie.R
import com.estherobei.jounmovie.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}