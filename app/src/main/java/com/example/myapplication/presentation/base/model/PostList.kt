package com.example.myapplication.presentation.base.model

import com.example.myapplication.R
import java.util.Calendar
import java.util.Date

data class PostList(val postList: List<Post>)

data class Post(
    val name: String,
    val image: Int = R.drawable.play_icon,
    val likeCount: Int = 9,
    val commCount: Int = 13,
    val repCount: Int = 2,
    val time: Date = Calendar.getInstance().time
)