package com.catstagram.android.feature.feature_basescreen.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BaseScreenViewModel @Inject constructor(
    private val storyRepository: StoryRepository,
    private val postRepository: PostRepository,
) : ViewModel() {
    private val _uiBaseState = MutableStateFlow(BaseScreenUiState())
    val uiBaseState: StateFlow<BaseScreenUiState> = _uiBaseState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiBaseState.value = _uiBaseState.value.copy(isLoading = true)
            _uiBaseState.value = _uiBaseState.value.copy(
                stories = storyRepository.getAllAvailableStories(),
                posts = postRepository.getPosts(),
                isLoading = false,
            )
        }
    }
}