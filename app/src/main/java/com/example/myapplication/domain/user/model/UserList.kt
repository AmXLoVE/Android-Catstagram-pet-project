package com.example.myapplication.domain.user.model

import androidx.annotation.DrawableRes
import com.example.myapplication.R

data class User(
    val id: Int = -1,
    val name: String = "",
    @DrawableRes val icon: Int = -1,
)

val userList = listOf(
    User(0, "You", R.drawable.photo_icon),
    User(1, "Marat_WarTHUNDER", R.drawable.photo_icon),
    User(2, "Leha", R.drawable.photo_icon),
    User(3, "Albertina_Iglesias", R.drawable.photo_icon),
    User(4, "Masha228", R.drawable.photo_icon),
    User(5, "Pasha007", R.drawable.photo_icon),
    User(6, "ABCDEFGJKKK", R.drawable.photo_icon)
)