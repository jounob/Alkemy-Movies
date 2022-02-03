package com.estherobei.jounmovie.data.dataMovies

import com.estherobei.jounmovie.util.ApiConfiguration.API_KEY
import javax.inject.Inject

class DataSource @Inject constructor(
    private val service: Service) {
    suspend fun getPopularMovies(){
        service.popularMovies(API_KEY)
    }
}