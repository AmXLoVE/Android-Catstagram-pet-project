package com.example.myapplication.data.user

import com.example.myapplication.domain.base.model.Post
import com.example.myapplication.domain.base.model.postList
import com.example.myapplication.domain.user.model.SubscribeList
import com.example.myapplication.domain.user.model.User
import com.example.myapplication.domain.user.model.userList
import javax.inject.Inject

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

    fun getAllUserPosts(id: Int): List<Post> {
        return postList
            .filter { it.user.id == id }
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

    fun getUserPosts(id: Int): List<Post>{
        val userPosts = ArrayList<Post>()
        postList
            .filter { it.user.id == id }
            .forEach {
                userPosts.add(it)
            }
        return userPosts
    }
}