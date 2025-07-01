package com.example.myapplication.presentation.story.model

import androidx.annotation.DrawableRes
import com.example.myapplication.domain.base.model.Post
import com.example.myapplication.domain.story.model.StoryPreview

data class StoryScreenUiState(
    val name: String = "...",
    @DrawableRes val image: Int = 0,
    @DrawableRes val icon: Int = 0,
)