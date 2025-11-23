package com.catstagram.android.data.core_data.chat

import com.catstagram.android.data.core_data.chat.model.ChatDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ChatRepository @Inject constructor(
    private val chatRemoteDataSource: ChatRemoteDataSource,
) {

    suspend fun getChats(): List<ChatDto> {
        return chatRemoteDataSource.getChats()
    }
}