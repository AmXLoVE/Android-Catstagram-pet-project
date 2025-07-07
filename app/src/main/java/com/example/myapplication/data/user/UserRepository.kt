package com.example.myapplication.data.user

import com.example.myapplication.data.Repository
import com.example.myapplication.domain.user.model.SubscribeList
import com.example.myapplication.domain.user.model.User
import com.example.myapplication.domain.user.model.userList
import javax.inject.Inject

class UserRepository @Inject constructor(): Repository {
    fun getProfile(id: Int): User {
        return userList.filter { it.id == id }[0]
    }

    fun getUserSubscribers(id: Int): List<User> {
        val userList = ArrayList<User>()
        SubscribeList
            .filter { it.userTo.id == id }
            .forEach {
                userList.add(it.userFrom)
            }
        return userList
    }

    fun getUserSubscriptions(id: Int): List<User> {
        val userList = ArrayList<User>()
        SubscribeList
            .filter { it.userFrom.id == id }
            .forEach {
                userList.add(it.userTo)
            }
        return userList
    }

    fun getUserSubscribersCount(id: Int): Int {
        return SubscribeList.count { it.userTo.id == id }
    }

    fun getUserSubscriptionsCount(id: Int): Int {
        return SubscribeList.count { it.userFrom.id == id }
    }
}