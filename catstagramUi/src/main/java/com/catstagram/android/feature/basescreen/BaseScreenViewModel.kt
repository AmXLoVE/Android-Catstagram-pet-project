package com.catstagram.android.feature.basescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catstagram.android.data.core_data.post.PostRepository
import com.catstagram.android.data.core_data.story.StoryRepository
import com.catstagram.android.feature.basescreen.model.BaseScreenUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BaseScreenViewModel @Inject constructor(
    private val storyRepository: StoryRepository,
    private val postRepository: PostRepository,
) : ViewModel() {
    private val _uiBaseState: MutableStateFlow<BaseScreenUiModel> = MutableStateFlow(
        BaseScreenUiModel.Loading
    )
    val uiBaseState: StateFlow<BaseScreenUiModel> = _uiBaseState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val stories = storyRepository.getAllAvailableStories()
                val posts = postRepository.getPosts()

                _uiBaseState.update {
                    BaseScreenUiModel.Content(
                        stories = stories,
                        posts = posts,
                    )
                }
            } catch (e: Exception) {
                _uiBaseState.update {
                    BaseScreenUiModel.Error
                }
            }
        }
    }
}