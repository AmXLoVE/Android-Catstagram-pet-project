package com.catstagram.android.feature.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.catstagram.android.feature.basescreen.widget.TopBar
import com.catstagram.android.feature.chat.model.ChatDetailsScreenUiState

@Composable
fun ChatDetailsScreen(
    id: Int,
    vm: ChatDetailsViewModel = hiltViewModel(),
) {
    val state: ChatDetailsScreenUiState by vm.state.collectAsStateWithLifecycle()

    ChatDetailsContent(
        id = id,
        state = state,
        )
}

@Composable
internal fun ChatDetailsContent(
    id: Int,
    state: ChatDetailsScreenUiState,
) {
    Column()
    {
        TopBar()

        when(state) {
            is ChatDetailsScreenUiState.Content -> TODO()

            ChatDetailsScreenUiState.Error -> TODO()

            ChatDetailsScreenUiState.Loading -> TODO()
        }
    }
}

@Composable
@Preview
private fun OneChatScreenContentPreview() {
    ChatDetailsScreen(0)
}