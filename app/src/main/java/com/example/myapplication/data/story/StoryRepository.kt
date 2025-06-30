package com.example.myapplication.data.story

import com.example.myapplication.domain.story.model.Story
import com.example.myapplication.domain.story.model.StoryPreview
import com.example.myapplication.domain.story.model.storyList

class StoryRepository {
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
                        name = it.name,
                        icon = it.icon,
                        hasStory = true
                    )
                )
        }

        return list
    }

    /**
     * Вызывается для открытия нажатой истории и загрузки картинки
     */
    fun getCurrentStory(name: String): Story {
        return storyList.filter { it.name == name }[0]
    }

    /**
     * Вызывается для мест, где нужно узнать есть ли Story у конкретного пользователя
     *
     * Например: список пользователей, экран поиска, экран профиля
     */
    fun hasUserStory(name: String): Boolean {
        return storyList.any { it.name == name }
    }
}