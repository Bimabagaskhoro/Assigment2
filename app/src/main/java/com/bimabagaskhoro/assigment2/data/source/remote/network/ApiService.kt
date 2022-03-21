package com.bimabagaskhoro.assigment2.data.source.remote.network

import com.bimabagaskhoro.assigment2.data.source.remote.response.ResponseItemGuest
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getAllGuest(): ResponseItemGuest
}