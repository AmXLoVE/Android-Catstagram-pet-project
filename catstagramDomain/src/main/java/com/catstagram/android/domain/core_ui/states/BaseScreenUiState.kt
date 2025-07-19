package com.catstagram.android.domain.core_ui.states

data class BaseScreenUiState(
    val stories: List<StoryPreview> = emptyList(),
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = true,
)