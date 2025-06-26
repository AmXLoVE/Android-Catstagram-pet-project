package com.example.myapplication.presentation.base.model

import com.example.myapplication.R


data class Story(
    val name: String = "Undefined",
    val icon: Int = R.drawable.photo_icon,
    val image: Int = R.drawable.play_icon,
)

val storyList = listOf(
    Story("Leha", R.drawable.photo_icon),
    Story("Marat_WarTHUNDER", R.drawable.photo_icon),
    Story("Albertina_Iglesias", R.drawable.photo_icon),
    Story("Masha228", R.drawable.photo_icon),
    Story("Pasha007", R.drawable.photo_icon),
    Story("ABCDEFGJKKK", R.drawable.photo_icon)
)
