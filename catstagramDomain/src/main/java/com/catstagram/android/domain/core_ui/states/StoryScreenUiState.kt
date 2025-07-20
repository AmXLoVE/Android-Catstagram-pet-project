package com.catstagram.android.domain.core_ui.states

import androidx.annotation.DrawableRes
import com.catstagram.android.domain.core_user.User

data class StoryScreenUiState(
    val user: User,
    @DrawableRes val image: Int = 0,
)