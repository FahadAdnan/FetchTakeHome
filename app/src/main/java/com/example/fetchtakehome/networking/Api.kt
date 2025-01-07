package com.example.fetchtakehome.networking

import com.example.fetchtakehome.model.HiringItem
import retrofit2.http.GET

interface Api {
    @GET("hiring.json")
    suspend fun getHiringItems(): List<HiringItem>
}
