package com.estherobei.jounmovie.ui.movies

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.estherobei.jounmovie.data.model.MovieResult
import com.estherobei.jounmovie.databinding.ItemMovieBinding
import com.estherobei.jounmovie.util.ApiConfiguration.IMAGE_URL
import com.squareup.picasso.Picasso


class MoviesListViewHolder(
    view: View,
    clickListener: MoviesList,
    movies: List<MovieResult>
) :
    RecyclerView.ViewHolder(view) {
    private val binding = ItemMovieBinding.bind(view)

    fun bind(movie: MovieResult) = binding.apply {
        Picasso.get().load(IMAGE_URL + movie.posterPath).into(imMovieImage)
        txtNameMovie.text = movie.originalTitle
    }

    init {
       itemView.setOnClickListener {
            clickListener.onItemClick(adapterPosition, movies)
        }
    }
}
