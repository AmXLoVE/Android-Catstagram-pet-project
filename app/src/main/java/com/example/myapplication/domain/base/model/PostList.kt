package com.example.myapplication.domain.base.model

import com.example.myapplication.R
import com.example.myapplication.domain.user.model.User
import com.example.myapplication.domain.user.model.userList
import java.util.Calendar
import java.util.Date

/** Мокап данных из БД
 */
class Post(
    val user: User,
    val image: Int = R.drawable.play_icon,
    var likeCount: Int = 0,
    var commCount: Int = 0,
    var repCount: Int = 0,
    val time: Date = Calendar.getInstance().apply {
        set(Calendar.YEAR, 2025)
        set(Calendar.MONTH, Calendar.JULY)
        set(Calendar.DAY_OF_MONTH, 9)
        set(Calendar.HOUR_OF_DAY, 15)
        set(Calendar.MINUTE, 46)
        set(Calendar.SECOND, 0)
    }.time
)

val postList = listOf(
    Post(user = userList[1]),
    Post(user = userList[2]),
    Post(user = userList[3]),
    Post(user = userList[4]),
    Post(user = userList[5]),
    Post(user = userList[6]),
    Post(user = userList[1], image = R.drawable._22),
    Post(user = userList[2], image = R.drawable.app_icon),
    Post(user = userList[3], image = R.drawable.ic_launcher_background),
    Post(user = userList[4], image = R.drawable.__2025_06_29_103259),
    Post(user = userList[5], image = R.drawable.maxresdefault),
    Post(user = userList[6], image = R.drawable._22),
    Post(user = userList[2], image = R.drawable._22),
    Post(user = userList[3], image = R.drawable.app_icon),
    Post(user = userList[4], image = R.drawable.ic_launcher_background),
    Post(user = userList[5], image = R.drawable.__2025_06_29_103259),
    Post(user = userList[6], image = R.drawable.maxresdefault),
    Post(user = userList[0], image = R.drawable._22),
    Post(user = userList[2], image = R.drawable._22),
    Post(user = userList[3], image = R.drawable.app_icon),
    Post(user = userList[4], image = R.drawable.ic_launcher_background),
    Post(user = userList[5], image = R.drawable.__2025_06_29_103259),
    Post(user = userList[6], image = R.drawable.maxresdefault),
    Post(user = userList[1], image = R.drawable._22),
    Post(user = userList[4], image = R.drawable.ic_launcher_background),
    Post(user = userList[5], image = R.drawable.__2025_06_29_103259),
    Post(user = userList[6], image = R.drawable.maxresdefault),
    Post(user = userList[1], image = R.drawable._22),
    Post(user = userList[5], image = R.drawable.maxresdefault),
    Post(user = userList[6], image = R.drawable._22),
    Post(user = userList[2], image = R.drawable._22),
    Post(user = userList[3], image = R.drawable.app_icon),
    Post(user = userList[4], image = R.drawable.ic_launcher_background),
    Post(user = userList[5], image = R.drawable.__2025_06_29_103259),
    Post(user = userList[6], image = R.drawable.maxresdefault),
    Post(user = userList[0], image = R.drawable._22),
    Post(user = userList[2], image = R.drawable._22),
    Post(user = userList[3], image = R.drawable.app_icon),
    Post(user = userList[4], image = R.drawable.ic_launcher_background),
    Post(user = userList[5], image = R.drawable.__2025_06_29_103259),
)