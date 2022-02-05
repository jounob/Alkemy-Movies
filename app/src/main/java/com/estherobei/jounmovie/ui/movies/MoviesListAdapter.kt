package com.estherobei.jounmovie.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.estherobei.jounmovie.R
import com.estherobei.jounmovie.data.Resource
import com.estherobei.jounmovie.data.model.MovieResult

class MoviesListAdapter(val movies: List<MovieResult>, val clickListener: MoviesList
                        ) : RecyclerView.Adapter<MoviesListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent,false)
        return MoviesListViewHolder(view,  clickListener, movies)
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size


}

interface ClickListener {
    fun onItemClick(position: Int, movies: List<MovieResult>)
}