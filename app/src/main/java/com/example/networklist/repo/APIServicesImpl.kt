package com.example.networklist.repo

import com.example.networklist.model.BaseUser
import javax.inject.Inject

class APIServicesImpl
@Inject constructor(private val apiServices: APIServices) {
    suspend fun getUserList(): BaseUser = apiServices.getUser()
}