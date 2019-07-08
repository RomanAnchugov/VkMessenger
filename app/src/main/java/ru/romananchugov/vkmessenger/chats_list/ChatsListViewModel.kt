package ru.romananchugov.vkmessenger.chats_list

import ru.romananchugov.domain.chats_list.ChatsListUseCase
import ru.romananchugov.vkmessenger.base_classes.BaseViewModel
import timber.log.Timber

class ChatsListViewModel(private val chatsListUseCase: ChatsListUseCase) : BaseViewModel() {
     fun onTest(){
         Timber.i("Just test ${chatsListUseCase.getChatsList()}")

     }

}