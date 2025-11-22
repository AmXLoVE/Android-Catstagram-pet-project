package com.catstagram.android.domain.story

import com.catstagram.android.domain.user.User
import com.catstagram.android.domain.user.userList
import com.example.catstagramdomain.R

data class Story(
    val user: User,
    val image: Int,
)

val storyList = listOf(
    Story(userList[0], R.drawable.maxresdefault),
    Story(userList[1], R.drawable.maxresdefault),
    Story(userList[2], R.drawable._22),
    Story(userList[3], R.drawable.__2025_06_29_103259),
    Story(userList[4], R.drawable.__2025_06_29_115926),
    Story(userList[5], R.drawable.ic_launcher_background),
    Story(userList[6],R.drawable.play_icon)
)
