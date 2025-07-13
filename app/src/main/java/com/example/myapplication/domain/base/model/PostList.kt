package com.example.myapplication.domain.base.model

import com.example.myapplication.domain.user.model.User
import java.util.Calendar
import java.util.Date

class Post(
    val user: User,
    val image: String = "",
    val width: Int = 0,
    val height: Int = 0,
    val likeCount: Int = 0,
    val commCount: Int = 0,
    val repCount: Int = 0,
    val time: Date = Calendar.getInstance().time
)