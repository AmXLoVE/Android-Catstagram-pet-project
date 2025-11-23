package com.catstagram.android.feature.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catstagram.android.data.core_data.chat.ChatRepository
import com.catstagram.android.feature.chat.mapper.ChatsUiStateMapper
import com.catstagram.android.feature.chat.model.ChatScreenUiState
import com.catstagram.android.feature.chat.model.OneChatScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class OneChatViewModel @Inject constructor(
    private val chatRepository: ChatRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<OneChatScreenUiState> = MutableStateFlow(
        value = OneChatScreenUiState.Loading,
    )
    val state: StateFlow<OneChatScreenUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {

        }
    }
}