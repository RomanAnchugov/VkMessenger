package ru.romananchugov.vkmessenger.domain.chats_list

import ru.romananchugov.vkmessenger.domain.BaseRepository

interface ChatsListRepository: BaseRepository {
    fun getChatsList(): List<ChatItem>
}