package ru.romananchugov.vkmessenger.domain.chats_list

import ru.romananchugov.vkmessenger.domain.BaseUseCase

class ChatsListUseCase(private val chatsListRepository: ChatsListRepository) : BaseUseCase(){

    fun getChatsList(): List<ChatItem>{
        return chatsListRepository.getChatsList()
    }

    fun isLoggedIn(): Boolean{
        return chatsListRepository.isUserLoggedIn()
    }

}