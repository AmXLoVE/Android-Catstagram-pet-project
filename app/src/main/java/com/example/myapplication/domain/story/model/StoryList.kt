package com.example.myapplication.domain.story.model

import com.example.myapplication.R

/**
 * Мокап данных из БД
 */
data class Story(
    val id: Int,
    val name: String = "Undefined",
    val image: Int,
    val icon: Int = R.drawable.photo_icon,
)

val storyList = listOf(
    Story(0, "You", R.drawable._22),
    Story(1, "Marat_WarTHUNDER", R.drawable.maxresdefault),
    Story(2, "Leha", R.drawable._22),
    Story(3, "Albertina_Iglesias", R.drawable.__2025_06_29_103259),
    Story(4, "Masha228", R.drawable.__2025_06_29_115926),
    Story(5, "Pasha007", R.drawable.ic_launcher_background),
    Story(6, "ABCDEFGJKKK", R.drawable.play_icon)
)
