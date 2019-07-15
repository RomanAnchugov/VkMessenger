package ru.romananchugov.vkmessenger.data.chats_list

import com.vk.api.sdk.VK
import ru.romananchugov.vkmessenger.domain.chats_list.ChatItem
import ru.romananchugov.vkmessenger.domain.chats_list.ChatsListRepository

class ChatsListRepositoryImpl:ChatsListRepository {

    private val chatsList = listOf(ChatItemNW(), ChatItemNW(), ChatItemNW())
    override fun getChatsList(): List<ChatItem> {

        return chatsList.map { it.toDomainItem() }
    }
    override fun isUserLoggedIn(): Boolean {
        return VK.isLoggedIn()
    }
}