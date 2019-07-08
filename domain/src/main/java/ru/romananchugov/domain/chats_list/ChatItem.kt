package ru.romananchugov.domain.chats_list

data class ChatItem(
    val chatName: String = "not specified",
    val latestMessagePreview: String = "not specified",
    //TODO: remade with url
    val imageUrl: String = "not specified"
)