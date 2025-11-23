package com.catstagram.android.feature.chat.model

import androidx.annotation.DrawableRes

internal sealed interface ChatScreenUiState {

    data object Error : ChatScreenUiState

    data object Loading : ChatScreenUiState

    data class Content(
        val chats: List<ChatScreenUiItem>,
    ) : ChatScreenUiState
}

internal data class ChatScreenUiItem(
    val id: Int,
    @DrawableRes val avatarRes: Int,
    val name: String,
    val lastMessage: String,
    val date: String,
    val isRead: Boolean,
    val hasHistory: Boolean,
)
