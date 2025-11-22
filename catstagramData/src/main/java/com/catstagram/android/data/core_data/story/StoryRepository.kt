package com.catstagram.android.data.core_data.story

import com.catstagram.android.domain.story.Story
import com.catstagram.android.domain.story.StoryPreview
import com.catstagram.android.domain.story.storyList
import com.catstagram.android.domain.user.User
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StoryRepository @Inject constructor() {
    fun getAllAvailableStories(): List<StoryPreview> { //TODO Можно кешировать
        val list: ArrayList<StoryPreview> = arrayListOf()

        storyList.forEach {
            if (hasUserStory(it.user.id))
                list.add(
                    StoryPreview(
                        user = it.user,
                        icon = it.user.icon,
                    )
                )
        }

        return list
    }

    fun getCurrentStory(id: Int): Story {
        return storyList[id]
    }

    fun hasUserStory(id: Int): Boolean {
        return storyList.any { it.user.id == id }
    }

    fun getNextStory(id: Int): Story {
        return try {
            storyList[storyList.indexOfFirst { it.user.id == id } + 1]
        } catch (_: Exception) {
            Story(User(), image = -1)
        }
    }

    fun getPrevStory(id: Int): Story {
        return try {
            storyList[storyList.indexOfFirst { it.user.id == id } - 1]
        } catch (_: Exception) {
            Story(User(), image = -1)
        }
    }
}