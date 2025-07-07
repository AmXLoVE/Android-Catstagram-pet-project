package com.example.myapplication.presentation.base.vm

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Repository
import com.example.myapplication.data.base.PostRepository
import com.example.myapplication.data.story.StoryRepository
import com.example.myapplication.presentation.base.ui.BaseScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BaseScreenViewModel @Inject constructor(
    private val storyRepository: Repository,
    private val postRepository: Repository,
) : ViewModel(){
    private val _uiBaseState = MutableStateFlow(BaseScreenUiState())
    val uiBaseState: StateFlow<BaseScreenUiState> = _uiBaseState.asStateFlow()

    init {
        loadStories()
    }

    private fun loadStories(){
        try{
            _uiBaseState.value = _uiBaseState.value.copy(
                stories = (storyRepository as StoryRepository).getAllAvailableStories(),
                posts = (postRepository as PostRepository).getLastNPost(999),
            )

            _uiBaseState.value = _uiBaseState.value.copy(isLoading = true)
        }
        catch (e: Exception){
            throw IllegalArgumentException()
        }
    }
}