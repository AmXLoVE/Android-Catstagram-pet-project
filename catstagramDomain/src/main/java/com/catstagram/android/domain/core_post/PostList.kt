package com.catstagram.android.domain.core_post

import com.catstagram.android.domain.core_user.User
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