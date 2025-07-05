package com.example.myapplication.data.story

import com.example.myapplication.domain.story.model.Story
import com.example.myapplication.domain.story.model.StoryPreview
import com.example.myapplication.domain.story.model.storyList
import javax.inject.Inject

class StoryRepository @Inject constructor() {
    /**
     * Вызывается для ленты новостей - отображает доступные Story
     * посредством StoryPreview
     * [com.example.myapplication.domain.story.model.Story]
     */
    fun getAllAvailableStories(): List<StoryPreview> { //TODO Можно кешировать
        val list: ArrayList<StoryPreview> = arrayListOf()

        storyList.forEach {
            if (hasUserStory(it.name))
                list.add(
                    StoryPreview(
                        id = it.id,
                        name = it.name,
                        icon = it.icon,
                    )
                )
        }

        return list
    }

    /**
     * Вызывается для открытия нажатой истории и загрузки картинки
     */
    fun getCurrentStory(id: Int): Story {
        return storyList[id]
    }

    /**
     * Вызывается для мест, где нужно узнать есть ли Story у конкретного пользователя
     *
     * Например: список пользователей, экран поиска, экран профиля
     */
    fun hasUserStory(name: String): Boolean {
        return storyList.any { it.name == name }
    }

    fun getNextStory(id: Int): Story {
        return try {
            storyList[storyList.indexOfFirst { it.id == id } + 1]
        } catch (e: Exception) {
            Story(-1, image = -1)
        }
    }

    fun getPrevStory(id: Int): Story {
        return try {
            storyList[storyList.indexOfFirst { it.id == id } - 1]
        } catch (e: Exception) {
            Story(-1, image = -1)
        }
    }
}