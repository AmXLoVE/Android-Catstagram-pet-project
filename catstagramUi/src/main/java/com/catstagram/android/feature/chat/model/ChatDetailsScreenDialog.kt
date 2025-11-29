package com.catstagram.android.feature.chat.model

data class ChatDetailsScreenDialog(
    val dialogId: Int,
    val ownerId: Int,
    val companionId: Int,
    val companionAvatar: Int,
    val messages: List<Message>,

)

data class Message(
    val messageId: Int,
    val isUser: Boolean,
    val isRead: Boolean,
    val dispatchTime: String = "now",
    val text: String = "",
    val image: Int = 0,
)