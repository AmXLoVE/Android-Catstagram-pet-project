package com.example.myapplication.presentation.base.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.data.RetrofitInstance
import com.example.myapplication.data.base.PostRepository
import com.example.myapplication.data.story.StoryRepository
import com.example.myapplication.domain.base.model.Post
import com.example.myapplication.domain.base.model.postList
import com.example.myapplication.domain.user.model.User
import com.example.myapplication.presentation.base.ui.BaseScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Random
import javax.inject.Inject

@HiltViewModel
class BaseScreenViewModel @Inject constructor(
    private val storyRepository: StoryRepository,
    private val postRepository: PostRepository,
) : ViewModel() {
    private val _uiBaseState = MutableStateFlow(BaseScreenUiState())
    val uiBaseState: StateFlow<BaseScreenUiState> = _uiBaseState.asStateFlow()

    init {
        loadStories()
    }

    private fun loadStories() {
        viewModelScope.launch {
            _uiBaseState.value = _uiBaseState.value.copy(
                stories = storyRepository.getAllAvailableStories(),
                posts = listOf(
                    Post(
                        user = postList[0].user,
                        image = postRepository.getCatImage()
                    ),
                    Post(
                        user = postList[1].user,
                        image = postRepository.getCatImage()
                    ),
                )
            )
            _uiBaseState.value = _uiBaseState.value.copy(isLoading = true)
        }
    }
}