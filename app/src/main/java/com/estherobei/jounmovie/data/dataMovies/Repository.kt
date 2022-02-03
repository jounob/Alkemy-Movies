package com.estherobei.jounmovie.data.dataMovies

import javax.inject.Inject

class Repository @Inject constructor(private val dataSource: DataSource
){
    suspend fun movies(){
        dataSource.getPopularMovies()
    }
}