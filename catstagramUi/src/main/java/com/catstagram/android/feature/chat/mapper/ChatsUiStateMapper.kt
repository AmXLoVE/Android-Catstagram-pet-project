package com.catstagram.android.feature.chat.mapper

import com.catstagram.android.data.core_data.chat.model.ChatDto
import com.catstagram.android.feature.chat.model.ChatScreenUiItem
import javax.inject.Inject

internal class ChatsUiStateMapper @Inject constructor() {

    fun map(chatDto: ChatDto): ChatScreenUiItem = ChatScreenUiItem(
        id = chatDto.id,
        avatarRes = chatDto.avatarRes,
        name = chatDto.name,
        lastMessage = chatDto.lastMessage,
        date = chatDto.date,
        isRead = chatDto.isRead,
        hasHistory = chatDto.hasHistory,
    )
}