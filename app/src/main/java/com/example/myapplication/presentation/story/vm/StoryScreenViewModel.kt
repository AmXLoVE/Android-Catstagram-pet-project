package com.example.myapplication.presentation.story.vm

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.Repository
import com.example.myapplication.data.story.StoryRepository
import com.example.myapplication.domain.user.model.User
import com.example.myapplication.presentation.story.model.StoryScreenUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StoryScreenViewModel @Inject constructor(
    private val storyRepository: Repository,
) : ViewModel() {
    private val _uiStoryState = MutableStateFlow(StoryScreenUiState(User()))
    val uiStoryState: StateFlow<StoryScreenUiState> = _uiStoryState.asStateFlow()

    fun loadStory(index: Int): StoryScreenUiState {
        try {
            val curStory = (storyRepository as StoryRepository).getCurrentStory(index)
            _uiStoryState.value = _uiStoryState.value.copy(
                image = curStory.image,
                user = User(
                    id = curStory.user.id,
                    name = curStory.user.name,
                    icon = curStory.user.icon
                )
            )
        } catch (_: Exception) {
            throw IllegalArgumentException()
        }
        return uiStoryState.value
    }

    fun findById(id: Int) {
        val foundStory = (storyRepository as StoryRepository).getCurrentStory(id)
        _uiStoryState.value = _uiStoryState.value.copy(
            user = User(
                id = foundStory.user.id,
                name = foundStory.user.name,
                icon = foundStory.user.icon
            ),
            image = foundStory.image,
        )
    }

    fun countAvailableStories(): Int {
        return (storyRepository as StoryRepository).getAllAvailableStories().size
    }

    fun getNextStory() {
        loadStory((storyRepository as StoryRepository).getNextStory(uiStoryState.value.user.id).user.id)
    }

    fun getPrevStory() {
        loadStory((storyRepository as StoryRepository).getPrevStory(uiStoryState.value.user.id).user.id)
    }

    fun getFirstStory() {
        val foundedStories = (storyRepository as StoryRepository).getAllAvailableStories()
        if (foundedStories.size > 1) {
            val foundedStory = storyRepository.getCurrentStory(foundedStories[1].user.id)
            _uiStoryState.value = _uiStoryState.value.copy(
                user = User(
                    id = foundedStory.user.id,
                    name = foundedStory.user.name,
                    icon = foundedStory.user.icon,
                ),
                image = foundedStory.image,
            )
        }
    }

    fun storyIsUnavailable(story: StoryScreenUiState): Boolean {
        return story.user.id == -1 ||
                story.user.name == "" ||
                story.image == 0 ||
                story.user.icon == 0
    }
}