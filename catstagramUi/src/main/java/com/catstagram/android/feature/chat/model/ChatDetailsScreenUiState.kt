package com.catstagram.android.feature.chat.model

sealed interface ChatDetailsScreenUiState {

    data object Error : ChatDetailsScreenUiState

    data object Loading : ChatDetailsScreenUiState

    data class Content(
        val chat: ChatDetailsScreenDialog,
    ) : ChatDetailsScreenUiState
}