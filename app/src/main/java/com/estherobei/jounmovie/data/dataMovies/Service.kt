package com.estherobei.jounmovie.data.dataMovies

import com.estherobei.jounmovie.data.model.ApiResponse
import com.estherobei.jounmovie.data.model.MovieResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET("movie/popular")
    suspend fun popularMovies(
        @Query("api_key") api_key: String,
        @Query("page") page: Int = 1
    ): Response<ApiResponse<List<MovieResult>>>
}