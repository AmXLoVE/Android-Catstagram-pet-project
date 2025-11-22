package com.catstagram.android.feature.basescreen.model

import com.catstagram.android.domain.post.Post
import com.catstagram.android.domain.story.StoryPreview
import com.catstagram.android.domain.user.userListPlaceHolder
import com.example.catstagramdomain.R

sealed interface BaseScreenUiModel {

    data object Error : BaseScreenUiModel

    data object Loading : BaseScreenUiModel

    data class Content(
        val stories: List<StoryPreview>,
        val posts: List<Post>,
    ) : BaseScreenUiModel
}

//data class BaseScreenUiState(
//    val stories: List<StoryPreview> = emptyList(),
//    val posts: List<Post> = emptyList(),
//    val isLoading: Boolean = true,
//)