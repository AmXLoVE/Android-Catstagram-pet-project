package com.example.myapplication.presentation.profile.vm

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.story.StoryRepository
import com.example.myapplication.data.user.UserRepository
import com.example.myapplication.domain.base.model.Post
import com.example.myapplication.domain.user.model.User
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
): ViewModel(){
    private val _uiProfileState = MutableStateFlow(ProfileUiState())
    val uiProfileState: StateFlow<ProfileUiState> = _uiProfileState.asStateFlow()

    init {
        loadProfile(0)
    }

    fun loadProfile(id: Int) {
        val user = userRepository.getProfile(id)
        val posts = userRepository.getAllUserPosts(id)
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

    fun getUsersPostCount(): Int{
        return uiProfileState.value.postList.size
    }

    fun getUserPostFromIndex(index: Int): Post{
        return uiProfileState.value.postList[index]
    }

    fun getUserSubscriberCount(): Int{
        return userRepository.getUserSubscribersCount(uiProfileState.value.id)
    }

    fun getUserSubscriptionCount(): Int{
        return userRepository.getUserSubscriptionsCount(uiProfileState.value.id)
    }

    fun getUserSubscribers(): List<User>{
        return userRepository.getUserSubscribers(uiProfileState.value.id)
    }

    fun getUserSubscriptions(): List<User>{
        return userRepository.getUserSubscriptions(uiProfileState.value.id)
    }
}