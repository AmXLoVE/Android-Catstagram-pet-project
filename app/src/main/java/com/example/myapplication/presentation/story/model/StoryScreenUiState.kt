package com.example.myapplication.presentation.story.model

import androidx.annotation.DrawableRes
import com.example.myapplication.domain.user.model.User

data class StoryScreenUiState(
    val user: User,
    @DrawableRes val image: Int = 0,
)