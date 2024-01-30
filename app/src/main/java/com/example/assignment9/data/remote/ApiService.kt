package com.example.assignment9.data.remote

import com.example.assignment9.data.model.ItemInformation
import retrofit2.http.GET

interface ApiService {
    @GET("v3/1775d634-92dc-4c32-ae71-1707b8cfee41")
    suspend fun getItems(): List<ItemInformation>
}