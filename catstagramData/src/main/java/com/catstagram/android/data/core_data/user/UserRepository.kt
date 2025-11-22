package com.catstagram.android.data.core_data.user

import com.catstagram.android.domain.user.SubscribeList
import com.catstagram.android.domain.user.User
import com.catstagram.android.domain.user.userList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor() {
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