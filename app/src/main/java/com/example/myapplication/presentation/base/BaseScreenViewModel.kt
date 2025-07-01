package com.example.myapplication.presentation.base

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.base.PostRepository
import com.example.myapplication.data.story.StoryRepository
import com.example.myapplication.presentation.base.ui.BaseScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BaseScreenViewModel @Inject constructor(
    private val storyRepository: StoryRepository,
    private val postRepository: PostRepository,
) : ViewModel(){
    private val _uiBaseState = MutableStateFlow(BaseScreenUiState())
    val uiBaseState: StateFlow<BaseScreenUiState> = _uiBaseState

    init {
        loadStories()
    }

    private fun loadStories(){
        try{
            _uiBaseState.value = _uiBaseState.value.copy(
                stories = storyRepository.getAllAvailableStories(),
                posts = postRepository.getLastNPost(999),
            )

            _uiBaseState.value = _uiBaseState.value.copy(isLoading = true)
        }
        catch (e: Exception){
            throw IllegalArgumentException()
        }
    }
}

/*
class BaseScreenViewModelFactory(
    private val storyRepository: StoryRepository,
    private val postRepository: PostRepository,
): ViewModelProvider.Factory{
    override fun <T: ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(BaseScreenViewModel::class.java)){
            return BaseScreenViewModel(storyRepository, postRepository) as T
        }
        throw IllegalArgumentException("unknown ViewModel class")
    }
}*/
