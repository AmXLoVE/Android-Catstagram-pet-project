package com.example.myapplication.presentation.profile.vm

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.base.PostRepository
import com.example.myapplication.data.story.StoryRepository
import com.example.myapplication.data.user.UserRepository
import com.example.myapplication.presentation.profile.ui.ProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val storyRepository: StoryRepository,
    private val postRepository: PostRepository,
): ViewModel(){
    private val _uiProfileState = MutableStateFlow(ProfileUiState())
    val uiProfileState: StateFlow<ProfileUiState> = _uiProfileState.asStateFlow()

    init {
        loadProfile(0)
    }

    fun loadProfile(id: Int) {
        val user = userRepository.getProfile(id)
        val posts = postRepository.getAllUserPosts(id)
        _uiProfileState.value = _uiProfileState.value.copy(
            id = user.id,
            name = user.name,
            icon = user.icon,
            postList = posts,
            hasStory = storyRepository.hasUserStory(id)
        )
    }

    fun userHasStory(): Boolean{
        return uiProfileState.value.hasStory
    }
}