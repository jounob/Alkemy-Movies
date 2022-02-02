package com.estherobei.jounmovie.ui.movieDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.estherobei.jounmovie.R
import com.estherobei.jounmovie.databinding.FragmentMovieDetailsBinding
import com.estherobei.jounmovie.databinding.FragmentMoviesListBinding

class MovieDetails : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentMovieDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

}