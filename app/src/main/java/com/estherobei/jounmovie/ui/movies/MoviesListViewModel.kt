package com.estherobei.jounmovie.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.estherobei.jounmovie.data.Resource
import com.estherobei.jounmovie.data.dataMovies.Repository
import com.estherobei.jounmovie.data.model.MovieResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MoviesListViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _movieResult = MutableLiveData<Resource<List<MovieResult>>>()
    val moviesResult: LiveData<Resource<List<MovieResult>>> = _movieResult

    init {
        getMoviesResult(1)
    }

    fun getMoviesResult(page:Int ) {
        viewModelScope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                repository.movies()
            }

            _movieResult.value = result
        }
    }

}