package com.catstagram.android.feature.chat.model

internal sealed interface OneChatScreenUiState {

    data object Error : OneChatScreenUiState

    data object Loading : OneChatScreenUiState

    data class Content(
        val chat: OneChatScreenDialog,
    ) : OneChatScreenUiState
}