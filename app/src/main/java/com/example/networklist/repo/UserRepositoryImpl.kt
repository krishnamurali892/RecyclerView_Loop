package com.example.networklist.repo

import com.example.networklist.model.BaseUser

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class UserRepositoryImpl
@Inject constructor(private var apiServicesImpl: APIServicesImpl){
    fun getUserList(): Flow<BaseUser>  = flow{
        var response = apiServicesImpl.getUserList()
        emit(response)
    }.flowOn(Dispatchers.IO)
}