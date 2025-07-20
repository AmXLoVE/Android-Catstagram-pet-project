package com.catstagram.android.domain.core_ui.states

import com.catstagram.android.domain.core_post.Post
import com.catstagram.android.domain.core_story.StoryPreview

data class BaseScreenUiState(
    val stories: List<StoryPreview> = emptyList(),
    val posts: List<Post> = emptyList(),
    val isLoading: Boolean = true,
)