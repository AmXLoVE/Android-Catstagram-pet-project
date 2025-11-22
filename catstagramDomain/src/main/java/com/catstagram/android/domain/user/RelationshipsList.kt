package com.catstagram.android.domain.user

data class Subscribe(
    val id: Int,
    val userFrom: User,
    val userTo: User,
)

val SubscribeList = listOf(
    Subscribe(id = 0, userFrom = userList[0], userTo = userList[1]),
    Subscribe(id = 0, userFrom = userList[0], userTo = userList[2]),
    Subscribe(id = 0, userFrom = userList[0], userTo = userList[3]),
    Subscribe(id = 0, userFrom = userList[0], userTo = userList[4]),
    Subscribe(id = 0, userFrom = userList[0], userTo = userList[5]),
    Subscribe(id = 0, userFrom = userList[1], userTo = userList[0]),
    Subscribe(id = 0, userFrom = userList[1], userTo = userList[2]),
    Subscribe(id = 0, userFrom = userList[1], userTo = userList[3]),
    Subscribe(id = 0, userFrom = userList[1], userTo = userList[6]),
    Subscribe(id = 0, userFrom = userList[2], userTo = userList[1]),
    Subscribe(id = 0, userFrom = userList[2], userTo = userList[3]),
    Subscribe(id = 0, userFrom = userList[2], userTo = userList[4]),
    Subscribe(id = 0, userFrom = userList[2], userTo = userList[5]),
    Subscribe(id = 0, userFrom = userList[3], userTo = userList[0]),
    Subscribe(id = 0, userFrom = userList[3], userTo = userList[1]),
    Subscribe(id = 0, userFrom = userList[3], userTo = userList[2]),
    Subscribe(id = 0, userFrom = userList[3], userTo = userList[5]),
    Subscribe(id = 0, userFrom = userList[4], userTo = userList[0]),
    Subscribe(id = 0, userFrom = userList[4], userTo = userList[2]),
    Subscribe(id = 0, userFrom = userList[4], userTo = userList[3]),
    Subscribe(id = 0, userFrom = userList[4], userTo = userList[6]),
    Subscribe(id = 0, userFrom = userList[5], userTo = userList[6]),
    Subscribe(id = 0, userFrom = userList[5], userTo = userList[4]),
)