package com.catstagram.android.feature.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.catstagram.android.feature.basescreen.widget.TopBar
import com.catstagram.android.feature.chat.model.ChatScreenUiItem
import com.catstagram.android.feature.chat.model.ChatScreenUiState
import com.catstagram.android.feature.chat.widget.ChatScreenContent
import com.catstagram.android.feature.chat.widget.ChatScreenError
import com.catstagram.android.feature.chat.widget.ChatScreenLoading
import com.example.catstagramui.R

@Composable
internal fun ChatScreen(
    vm: ChatViewModel = hiltViewModel()
) {
    val state: ChatScreenUiState by vm.state.collectAsStateWithLifecycle()

    ChatScreenC(state = state)
}

@Composable
private fun ChatScreenC(
    state: ChatScreenUiState
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TopBar()

        when (state) {
            is ChatScreenUiState.Content -> ChatScreenContent(
                state = state,
                onChatClick = {}, // TODO доделать
            )

            ChatScreenUiState.Error -> ChatScreenError()
            ChatScreenUiState.Loading -> ChatScreenLoading()
        }
    }
}

@Composable
@Preview
private fun ChatScreenCPreview() {
    ChatScreenC(
        state = ChatScreenUiState.Content(
            chats = List(6) { index ->
                ChatScreenUiItem(
                    id = 0,
                    avatarRes = R.drawable.photo_icon,
                    name = "name",
                    lastMessage = "some message",
                    date = "2m ago",
                    isRead = index == 3,
                    hasHistory = index == 2,
                )
            },
        )
    )
}
