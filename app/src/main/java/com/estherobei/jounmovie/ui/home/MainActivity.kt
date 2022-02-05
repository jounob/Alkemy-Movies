package com.estherobei.jounmovie.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.estherobei.jounmovie.R
import com.estherobei.jounmovie.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        navController = findNavController(R.id.fragmentContainerView)
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.movieDetails, R.id.moviesList
        ))
//        setupActionBarWithNavController(navController, appBarConfiguration)

        setContentView(binding.root)
    }
}