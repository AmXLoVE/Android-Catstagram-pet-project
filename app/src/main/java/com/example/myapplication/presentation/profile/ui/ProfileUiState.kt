package com.example.myapplication.presentation.profile.ui

import androidx.annotation.DrawableRes
import com.example.myapplication.domain.base.model.Post

data class ProfileUiState(
    val id: Int = -1,
    val name: String = "",
    @DrawableRes val icon: Int = -1,
    val postList: List<Post> = emptyList(),
    val hasStory: Boolean = false,
)