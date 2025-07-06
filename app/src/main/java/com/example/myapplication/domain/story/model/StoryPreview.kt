package com.example.myapplication.domain.story.model

import com.example.myapplication.domain.user.model.User

data class StoryPreview(
    val user: User,
    val icon: Int,
)