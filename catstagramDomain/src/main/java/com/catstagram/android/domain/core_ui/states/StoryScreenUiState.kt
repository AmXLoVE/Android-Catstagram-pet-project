package com.catstagram.android.domain.core_ui.states

import androidx.annotation.DrawableRes

data class StoryScreenUiState(
    val user: User,
    @DrawableRes val image: Int = 0,
)