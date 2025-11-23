package com.catstagram.android.data.core_data.chat.model

import androidx.annotation.DrawableRes
import com.catstagram.android.domain.user.userList
import kotlin.random.Random

data class ChatDto(
    val id: Int,
    @DrawableRes val avatarRes: Int,
    val name: String,
    val lastMessage: String,
    val date: String,
    val isRead: Boolean,
    val hasHistory: Boolean,
) {

    companion object {

        fun getChats() = userList.map { user ->
            val isReadRandom = Random.nextInt(1, 3) == 1
            val hasHistoryRandom = Random.nextInt(1, 3) == 2

            ChatDto(
                id = user.id,
                name = user.name,
                avatarRes = user.icon,
                lastMessage = "hello",
                date = "2m ago",
                isRead = isReadRandom,
                hasHistory = hasHistoryRandom,
            )
        }
    }
}
