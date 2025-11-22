package com.catstagram.android.domain.story

import com.catstagram.android.domain.user.User

data class StoryPreview(
    val user: User,
    val icon: Int,
)