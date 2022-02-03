package com.estherobei.jounmovie.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.estherobei.jounmovie.databinding.FragmentMoviesListBinding


class MoviesList : Fragment() {

    private lateinit var binding: FragmentMoviesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoviesListBinding.inflate(inflater, container, false)

        return binding.root
    }

}