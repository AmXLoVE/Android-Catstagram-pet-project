package com.example.myapplication.data.story

import com.example.myapplication.R
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

object StoryRepository2 {

    val storyList = listOf(
        Story("You", R.drawable._22),
        Story("Leha", R.drawable._22),
        Story("Marat_WarTHUNDER", R.drawable.maxresdefault),
        Story("Albertina_Iglesias", R.drawable.__2025_06_29_103259),
        Story("Masha228", R.drawable.__2025_06_29_115926),
        Story("Pasha007", R.drawable.ic_launcher_background),
        Story("ABCDEFGJKKK", R.drawable.play_icon)
    )

}