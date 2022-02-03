package com.estherobei.jounmovie.data.dataMovies

import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("/movie/popular")
    suspend fun popularMovies (
        @Query("api_key") api_key: String
    )
}