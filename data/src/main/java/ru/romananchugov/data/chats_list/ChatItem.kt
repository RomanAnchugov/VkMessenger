package ru.romananchugov.data.chats_list

data class ChatItem(
    val chatName: String = "not specified",
    val latestMessagePreview: String = "not specified",
    val imageUrl: String = "not specified"
)