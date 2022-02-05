package com.estherobei.jounmovie.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.estherobei.jounmovie.data.Resource
import com.estherobei.jounmovie.data.model.MovieResult
import com.estherobei.jounmovie.databinding.FragmentMoviesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesList : Fragment(), ClickListener {

    private lateinit var binding: FragmentMoviesListBinding
    private lateinit var adapter: MoviesListAdapter
    private val viewModel: MoviesListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMoviesListBinding.inflate(inflater, container, false)
//Observando el live data del viewModel
        viewModel.moviesResult.observe(viewLifecycleOwner) {
            //Manejo de estado
            when (it.status) {
                Resource.Status.LOADING -> {
                    Toast.makeText(this.context, "Load", Toast.LENGTH_LONG).show()
                }

                Resource.Status.SUCCESS -> {

                    adapter = MoviesListAdapter(it.data!!, this)
                    binding.rvMoviesList.adapter = adapter

                    Toast.makeText(this.context, "Success", Toast.LENGTH_LONG).show()
                }

                Resource.Status.ERROR -> {
                    Toast.makeText(this.context, "Error", Toast.LENGTH_LONG).show()
                }
            }
        }

        return binding.root
    }
//Funcion que envia y los datos y navega hacia MovieDetails
    override fun onItemClick(position: Int, movies: List<MovieResult>) {
        val action = MoviesListDirections.goToDetails(
            movies[position].backdropPath,
            movies[position].originalTitle,
            movies[position].originalLanguage,
            movies[position].overview,
            movies[position].posterPath,
            movies[position].voteAverage.toString(),
        )
       findNavController().navigate(action)
    }
}