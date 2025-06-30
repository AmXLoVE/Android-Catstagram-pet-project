package com.example.myapplication.domain.story.model

import com.example.myapplication.R

/**
 * Мокап данных из БД
 */
data class Story(
    val name: String = "Undefined",
    val image: Int,
    val icon: Int = R.drawable.photo_icon,
)

val storyList = listOf(
    Story("You", R.drawable._22),
    Story("Leha", R.drawable._22),
    Story("Marat_WarTHUNDER", R.drawable.maxresdefault),
    Story("Albertina_Iglesias", R.drawable.__2025_06_29_103259),
    Story("Masha228", R.drawable.__2025_06_29_115926),
    Story("Pasha007", R.drawable.ic_launcher_background),
    Story("ABCDEFGJKKK", R.drawable.play_icon)
)
