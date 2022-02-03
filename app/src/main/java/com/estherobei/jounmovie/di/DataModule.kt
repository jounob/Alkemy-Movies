package com.estherobei.jounmovie.di

import com.estherobei.jounmovie.data.dataMovies.DataSource
import com.estherobei.jounmovie.data.dataMovies.Service
import com.estherobei.jounmovie.util.ApiConfiguration.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)


class DataModule {
    @ApiMovie
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
       return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory
           .create()).client(okHttpClient).build()
    }
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)).build()
    }
    @Provides
    fun provideMovieService(retrofit: Retrofit): Service {
        return retrofit.create(Service::class.java)
    }

    @Provides
    fun provideMovieDataSource(service: Service): DataSource{
        return DataSource(service)
    }



}