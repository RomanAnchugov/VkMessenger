package ru.romananchugov.data.chats_list

class ChatsListRepository{

    private val testChatsList = listOf(
        ChatItem(),
        ChatItem(),
        ChatItem()
    )

    fun getChatsList(): List<ChatItem>{
        return testChatsList
    }
}