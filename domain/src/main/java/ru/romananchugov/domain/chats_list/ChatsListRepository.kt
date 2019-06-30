package ru.romananchugov.domain.chats_list

import ru.romananchugov.domain.BaseRepository

interface ChatsListRepository: BaseRepository {
    fun getChatsList()
}