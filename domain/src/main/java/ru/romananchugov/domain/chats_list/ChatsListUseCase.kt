package ru.romananchugov.domain.chats_list

import ru.romananchugov.domain.BaseUseCase

interface ChatsListUseCase: BaseUseCase {
    fun getChatsList()
}