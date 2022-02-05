package com.estherobei.jounmovie.data.dataMovies

import com.estherobei.jounmovie.data.BaseDataSource
import com.estherobei.jounmovie.util.ApiConfiguration.API_KEY
import javax.inject.Inject
class DataSource @Inject constructor(
    private val service: Service,
) : BaseDataSource() {

    suspend fun getPopularMovies() = getResult { service.popularMovies(API_KEY) }
}
