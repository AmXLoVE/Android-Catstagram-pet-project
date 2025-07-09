package com.example.myapplication.data.base

import java.text.SimpleDateFormat
import java.util.Locale
import com.example.myapplication.domain.base.model.Post
import com.example.myapplication.domain.base.model.postList
import java.util.Calendar
import java.util.Date
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PostRepository @Inject constructor() {
    /**
     * Вызывается для ленты новостей для N последних постов
     */
    fun getLastNPost(n: Int): List<Post> {
        if (n >= postList.size)
            return postList
        return postList.subList(0, n)
    }

    /**
     * Вызывается для открытия поста ([com.example.myapplication.domain.base.model.Post]) (пока хз зачем надо)
     */
    fun getCurrentPost(id: Int): Post {
        return postList
            .filter { it.user.id == id }[0]
    }

    fun getPostTime(
        postedTime: Date,
        nowTime: Date = Date(),
        locale: Locale = Locale("ru")
    ): String {
        val mseconds = nowTime.time - postedTime.time

        val seconds = TimeUnit.MILLISECONDS.toSeconds(mseconds)
        val minutes = TimeUnit.MILLISECONDS.toMinutes(mseconds)
        val hours = TimeUnit.MILLISECONDS.toHours(mseconds)
        val days = TimeUnit.MILLISECONDS.toDays(mseconds)

        return when {
            seconds < 60 -> "$seconds с."
            minutes < 60 -> "$minutes м."
            hours < 24 -> "$hours ч."
            days < 1L -> "вчера"
            days <= 3L -> "$days дней назад."
            else -> {
                val thisYear = Calendar.getInstance().get(Calendar.YEAR)
                val pastCal = Calendar.getInstance().apply { time = postedTime }
                val format: SimpleDateFormat = if (pastCal.get(Calendar.YEAR) == thisYear)
                    SimpleDateFormat("d MMMM", locale)
                else
                    SimpleDateFormat("d MMMM yyyy", locale)

                format.format(postedTime)
            }
        }
    }
}