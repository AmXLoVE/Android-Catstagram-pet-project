package com.catstagram.android.feature.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catstagram.android.data.core_data.chat.ChatRepository
import com.catstagram.android.feature.chat.mapper.ChatsUiStateMapper
import com.catstagram.android.feature.chat.model.ChatScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class ChatViewModel @Inject constructor(
    private val chatRepository: ChatRepository,
    private val chatsUiStateMapper: ChatsUiStateMapper,
) : ViewModel() {

    private val _state: MutableStateFlow<ChatScreenUiState> = MutableStateFlow(
        value = ChatScreenUiState.Loading,
    )
    val state: StateFlow<ChatScreenUiState> = _state.asStateFlow()

    init {
        updateFromServer()
    }

    fun update() {
        _state.update {
            ChatScreenUiState.Loading
        }
        updateFromServer()
    }

    fun updateFromServer() {
        viewModelScope.launch {
            try {
                val chats = chatRepository.getChats().map { chatDto ->
                    chatsUiStateMapper.map(chatDto = chatDto)
                }

                _state.update {
                    ChatScreenUiState.Content(
                        chats = chats,
                    )
                }
            } catch (e: Exception) {
                _state.update {
                    ChatScreenUiState.Error
                }
            }
        }
    }
}