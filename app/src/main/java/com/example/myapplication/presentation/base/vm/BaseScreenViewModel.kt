package com.example.myapplication.presentation.base.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.base.PostRepository
import com.example.myapplication.data.story.StoryRepository
import com.example.myapplication.presentation.base.ui.BaseScreenUiState
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