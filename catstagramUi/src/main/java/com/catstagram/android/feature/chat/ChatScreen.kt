package com.catstagram.android.feature.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
    onShowChat: (Int) -> Unit,
    vm: ChatViewModel = hiltViewModel()
) {
    val state: ChatScreenUiState by vm.state.collectAsStateWithLifecycle()

    ChatScreenC(
        state = state,
        updateContent = { vm.update() },
        onShowChat = onShowChat,
    )
}

@Composable
private fun ChatScreenC(
    state: ChatScreenUiState,
    updateContent: () -> Unit,
    onShowChat: (Int) -> Unit,
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
                onChatClick = onShowChat,
            )

            ChatScreenUiState.Error -> ChatScreenError(
                updateContent = updateContent
            )
            ChatScreenUiState.Loading -> ChatScreenLoading()
        }
    }
}
