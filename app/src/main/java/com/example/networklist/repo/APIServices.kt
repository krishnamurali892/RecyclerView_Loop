package com.example.networklist.repo



import com.example.networklist.model.BaseUser
import retrofit2.http.GET

interface APIServices {
    @GET("getUserLists")
    suspend fun getUser() : BaseUser
}