package com.estherobei.jounmovie.data

import com.estherobei.jounmovie.data.model.ApiResponse
import com.estherobei.jounmovie.data.model.MovieResult
import retrofit2.Response
import java.io.Serializable

abstract class BaseDataSource {
    protected suspend fun <T> getResult(call: suspend () -> Response<ApiResponse<T>>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()?.results
                if (body != null) return Resource.success(body)
            }
            return Resource.error("${response.code()}: ${response.message()}")
        } catch (e: Exception) {
            return Resource.error(e.message ?: "Generic error")
        }
    }
}

data class Resource<out T>(var status: Status, val data: T?, val message: String?) : Serializable {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(message: String, data: T? = null): Resource<T> {
            return Resource(
                Status.ERROR,
                data,
                message
            )
        }

        fun <T> loading(data: T? = null): Resource<T> {
            return Resource(
                Status.LOADING,
                data,
                null
            )
        }
    }
}