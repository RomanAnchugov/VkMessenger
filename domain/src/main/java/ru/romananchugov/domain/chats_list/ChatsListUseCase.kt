package ru.romananchugov.domain.chats_list

import ru.romananchugov.data.chats_list.ChatItem
import ru.romananchugov.data.chats_list.ChatsListRepository
import ru.romananchugov.domain.BaseUseCase

class ChatsListUseCase(
    private val chatsListRepository: ChatsListRepository
) : BaseUseCase() {

    fun getChatsList(): List<ChatItem> {

        return chatsListRepository.getChatsList()

    }
}