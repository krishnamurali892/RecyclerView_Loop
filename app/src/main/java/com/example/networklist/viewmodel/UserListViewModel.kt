package com.example.networklist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.networklist.model.BaseUser
import com.example.networklist.repo.UserRepositoryImpl

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel

@Inject constructor(userRepositoryImpl: UserRepositoryImpl):ViewModel(){
    var userResponse : LiveData<BaseUser> = userRepositoryImpl.getUserList()
        .catch { exception-> Log.d("asd", "Exception ${exception.message}") }
        .asLiveData()

}