package com.example.myapplication.presentation.story

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.story.StoryRepository
import com.example.myapplication.data.story.StoryRepository2
import com.example.myapplication.presentation.story.model.StoryScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class StoryScreenViewModel @Inject constructor(
    private val storyRepository: StoryRepository,
) : ViewModel(){
    private val _uiStoryState = MutableStateFlow(StoryScreenUiState())
    val uiStoryState: StateFlow<StoryScreenUiState> = _uiStoryState

    fun loadStory(name: String){
        try{
            val curStory = storyRepository.getCurrentStory(name)
            _uiStoryState.value = _uiStoryState.value.copy(
                name = curStory.name,
                image = curStory.image,
                icon = curStory.icon
            )
        }
        catch (e: Exception){
            throw IllegalArgumentException()
        }
    }

    fun findByName(name: String) {
        val findedStory = StoryRepository2.getByName(name)
        _uiStoryState.value = _uiStoryState.value.copy(
            name = findedStory.name,
            image = findedStory.image,
            icon = findedStory.icon,
        )
    }
}