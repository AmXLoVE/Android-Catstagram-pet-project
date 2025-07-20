package com.catstagram.android.domain.core_ui.states

import androidx.annotation.DrawableRes
import com.catstagram.android.domain.core_post.Post

data class ProfileUiState(
    val id: Int = -1,
    val name: String = "",
    val postList: List<Post> = emptyList(),
    val hasStory: Boolean = false,
    @DrawableRes val icon: Int = -1,
)