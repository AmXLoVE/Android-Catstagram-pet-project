package com.example.myapplication.presentation.base.model

import com.example.myapplication.R
import java.util.Calendar
import java.util.Date

class Post(
    val name: String,
    val icon: Int = R.drawable.photo_icon,
    val image: Int = R.drawable.play_icon,
    val likeCount: Int = 9,
    val commCount: Int = 13,
    val repCount: Int = 2,
    val time: Date = Calendar.getInstance().time
)

val PostList = listOf(
    Post(name = "ALBERTINA_0_o"),
    Post(name = "xXx_puli_ot_babuli_xXx"),
    Post(name = "Masha_Kulakova_7"),
    Post(name = "FoxVapeShop")
)