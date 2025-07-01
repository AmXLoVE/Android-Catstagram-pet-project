package com.example.myapplication.presentation.base.ui

import com.example.myapplication.domain.base.model.Post
import com.example.myapplication.domain.story.model.StoryPreview

data class BaseScreenUiState(
    val stories: List<StoryPreview> = emptyList(),
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = false,
    val toShowStory: String? = null
)