package com.catstagram.android.domain.core_story

import com.catstagram.android.domain.core_user.User

data class StoryPreview(
    val user: User,
    val icon: Int,
)