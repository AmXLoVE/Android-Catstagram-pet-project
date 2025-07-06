package com.example.myapplication.presentation.profile.vm

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.story.StoryRepository
import com.example.myapplication.presentation.profile.ui.ProfileUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileScreenViewModel @Inject constructor(
    private val storyRepository: StoryRepository,
): ViewModel(){
    fun loadProfile(id: Int): ProfileUiState {
        return ProfileUiState()
    }
}