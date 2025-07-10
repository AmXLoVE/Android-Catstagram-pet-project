package com.example.myapplication.domain.base.model

import com.example.myapplication.R
import com.example.myapplication.domain.user.model.User
import com.example.myapplication.domain.user.model.userList
import java.util.Calendar
import java.util.Date

/**
 * Мокап данных из БД
 */
class Post(
    val user: User,
    val image: String = "",
    val likeCount: Int = 0,
    val commCount: Int = 0,
    val repCount: Int = 0,
    val time: Date = Calendar.getInstance().time
)

val postList = listOf(
    Post(user = userList[1]),
    Post(user = userList[2]),
    Post(user = userList[3]),
    Post(user = userList[4]),
    Post(user = userList[5]),
    Post(user = userList[6]),
)