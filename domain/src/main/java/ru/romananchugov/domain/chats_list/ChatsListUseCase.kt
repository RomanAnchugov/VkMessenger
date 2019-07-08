package ru.romananchugov.domain.chats_list

import ru.romananchugov.domain.BaseUseCase

class ChatsListUseCase(
    private val chatsListRepository: ChatsListRepository
) : BaseUseCase() {
    fun getChatsList(): List<ChatItem> {
        return chatsListRepository.getChatsList()
    }
}