package ru.romananchugov.vkmessenger.chats_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.romananchugov.vkmessenger.base_classes.BaseViewModel
import ru.romananchugov.vkmessenger.domain.chats_list.ChatItem
import ru.romananchugov.vkmessenger.domain.chats_list.ChatsListUseCase

class ChatsListViewModel(private val chatsListUseCase: ChatsListUseCase) : BaseViewModel() {
    private val _chatsList: MutableLiveData<List<ChatItem>> = MutableLiveData()
    val chatsList: LiveData<List<ChatItem>>
        get() = _chatsList

    fun onViewCreated() {
        _chatsList.postValue(chatsListUseCase.getChatsList())
    }

}