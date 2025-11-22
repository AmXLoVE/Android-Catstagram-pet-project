package com.catstagram.android.feature.story.model

import androidx.annotation.DrawableRes
import com.catstagram.android.domain.user.User

data class StoryScreenUiState(
    val user: User,
    @DrawableRes val image: Int = 0,
)