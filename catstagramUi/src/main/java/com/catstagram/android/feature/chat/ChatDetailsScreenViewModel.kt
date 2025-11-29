package com.catstagram.android.feature.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catstagram.android.data.core_data.chat.ChatRepository
import com.catstagram.android.feature.chat.model.ChatDetailsScreenDialog
import com.catstagram.android.feature.chat.model.ChatDetailsScreenUiState
import com.catstagram.android.feature.chat.widget.ChatDetailsScreenContent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatDetailsViewModel @Inject constructor(
    private val chatRepository: ChatRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<ChatDetailsScreenUiState> = MutableStateFlow(
        value = ChatDetailsScreenUiState.Loading,
    )
    val state: StateFlow<ChatDetailsScreenUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.update {
                ChatDetailsScreenUiState.Content(chat = ChatDetailsScreenDialog(1, 1, 1, 1, emptyList()))
            }
        }
    }
}