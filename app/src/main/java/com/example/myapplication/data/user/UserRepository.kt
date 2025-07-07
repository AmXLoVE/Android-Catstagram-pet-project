package com.example.myapplication.data.user

import com.example.myapplication.domain.user.model.User
import com.example.myapplication.domain.user.model.userList
import javax.inject.Inject

class UserRepository @Inject constructor() {
    fun getProfile(id: Int): User{
        return userList.filter { it.id == id }[0]
    }
}