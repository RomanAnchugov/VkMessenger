package ru.romananchugov.data.chats_list

import ru.romananchugov.domain.chats_list.ChatItem
import ru.romananchugov.domain.chats_list.ChatsListRepository

class ChatsListRepositoryImpl: ChatsListRepository {
    private val testChatsList = listOf(
        ChatItem(),
        ChatItem(),
        ChatItem()
    )
    override fun getChatsList(): List<ChatItem>{

        return testChatsList
    }
}