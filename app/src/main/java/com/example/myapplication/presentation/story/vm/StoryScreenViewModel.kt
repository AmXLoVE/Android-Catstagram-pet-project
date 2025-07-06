package com.example.myapplication.presentation.story.vm

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.story.StoryRepository
import com.example.myapplication.presentation.story.model.StoryScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StoryScreenViewModel @Inject constructor(
    private val storyRepository: StoryRepository,
) : ViewModel() {
    private val _uiStoryState = MutableStateFlow(StoryScreenUiState(-1))
    val uiStoryState: StateFlow<StoryScreenUiState> = _uiStoryState.asStateFlow()

    fun loadStory(index: Int): StoryScreenUiState {
        try {
            val curStory = storyRepository.getCurrentStory(index)
            _uiStoryState.value = _uiStoryState.value.copy(
                id = curStory.user.id,
                name = curStory.user.name,
                image = curStory.image,
                icon = curStory.user.icon
            )
        } catch (_: Exception) {
            throw IllegalArgumentException()
        }
        return uiStoryState.value
    }

    fun findById(id: Int) {
        val foundStory = storyRepository.getCurrentStory(id)
        _uiStoryState.value = _uiStoryState.value.copy(
            name = foundStory.user.name,
            image = foundStory.image,
            icon = foundStory.user.icon,
        )
    }

    fun countAvailableStories(): Int{
        return storyRepository.getAllAvailableStories().size
    }

    fun getNextStory() {
        loadStory(storyRepository.getNextStory(uiStoryState.value.id).user.id)
    }

    fun getPrevStory() {
        loadStory(storyRepository.getPrevStory(uiStoryState.value.id).user.id)
    }

    fun getFirstStory() {
        val foundedStories = storyRepository.getAllAvailableStories()
        if (foundedStories.size > 1) {
            val foundedStory = storyRepository.getCurrentStory(foundedStories[1].user.id)
            _uiStoryState.value = _uiStoryState.value.copy(
                name = foundedStory.user.name,
                icon = foundedStory.user.icon,
                image = foundedStory.image,
            )
        }
    }

    fun storyIsUnavailable(story: StoryScreenUiState): Boolean{
        return story.id == -1 || story.name == "" || story.image == 0 || story.icon == 0
    }
}