package com.estherobei.jounmovie.ui.movieDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.estherobei.jounmovie.databinding.FragmentMovieDetailsBinding
import com.estherobei.jounmovie.util.ApiConfiguration.IMAGE_URL
import com.squareup.picasso.Picasso

class MovieDetails : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding
    val args: MovieDetailsArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)

//Recibe los datos del movie cliqueado anteriomente atraves de los safe args y
//tambien inicializa los views
        binding.apply {
            txtDescriptionMovie.text = args.overview
            txtQualification.text = args.originalLanguage
            Picasso.get().load(IMAGE_URL + args.backdropPath).into(imBackImage)
            txtNameMovieDetails.text = args.posterPath
            Picasso.get().load(IMAGE_URL + args.voteAverage).into(imCardViewImage)
            txtLanguage.text = args.originalTitle
        }

        return binding.root
    }
}