package com.catstagram.android.feature.chat.model

internal data class OneChatScreenDialog(
    val dialogId: Int,
    val ownerId: Int,
    val companionId: Int,
    val companionAvatar: Int,
    val messages: List<Message>,

)

internal data class Message(
    val dispatchTime: String = "now",
    val text: String = "",
    val image: Int = 0,
)