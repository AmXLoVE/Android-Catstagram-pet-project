package com.catstagram.android.feature.feature_profile.vm

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catstagram.android.data.core_data.post.PostRepository
import com.catstagram.android.data.core_data.story.StoryRepository
import com.catstagram.android.data.core_data.user.UserRepository
import com.catstagram.android.domain.core_post.Post
import com.catstagram.android.domain.core_ui.states.ProfileUiState
import com.catstagram.android.domain.core_user.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val storyRepository: StoryRepository,
    private val postRepository: PostRepository,
) : ViewModel() {
    private val _uiProfileState = MutableStateFlow(ProfileUiState())
    val uiProfileState: StateFlow<ProfileUiState> = _uiProfileState.asStateFlow()

    fun loadProfile(id: Int) {
        Log.i("asdf", "${postRepository.cachedPosts?.size}")
        viewModelScope.launch {
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
    }

    fun userHasStory(): Boolean {
        return uiProfileState.value.hasStory
    }

    fun getUsersPostCount(): Int {
        return uiProfileState.value.postList.size
    }

    fun getUserPostFromIndex(index: Int): Post {
        return uiProfileState.value.postList[index]
    }

    fun getUserSubscriberCount(): Int {
        return userRepository.getUserSubscribersCount(uiProfileState.value.id)
    }

    fun getUserSubscriptionCount(): Int {
        return userRepository.getUserSubscriptionsCount(uiProfileState.value.id)
    }

    fun getUserSubscribers(): List<User> {
        return userRepository.getUserSubscribers(uiProfileState.value.id)
    }

    fun getUserSubscriptions(): List<User> {
        return userRepository.getUserSubscriptions(uiProfileState.value.id)
    }
}