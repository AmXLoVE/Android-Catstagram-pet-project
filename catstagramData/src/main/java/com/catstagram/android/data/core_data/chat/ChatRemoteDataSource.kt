package com.catstagram.android.data.core_data.chat

import com.catstagram.android.data.core_data.chat.model.ChatDto
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatRemoteDataSource @Inject constructor() {

    suspend fun getChats(): List<ChatDto> {
        delay(2000)

        return ChatDto.getChats()
    }
}