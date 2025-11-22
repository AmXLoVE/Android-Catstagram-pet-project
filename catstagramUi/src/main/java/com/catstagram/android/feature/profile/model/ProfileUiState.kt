package com.catstagram.android.feature.profile.model

import androidx.annotation.DrawableRes
import com.catstagram.android.domain.post.Post

data class ProfileUiState(
    val id: Int = -1,
    val name: String = "",
    val postList: List<Post> = emptyList(),
    val hasStory: Boolean = false,
    @DrawableRes val icon: Int = -1,
)