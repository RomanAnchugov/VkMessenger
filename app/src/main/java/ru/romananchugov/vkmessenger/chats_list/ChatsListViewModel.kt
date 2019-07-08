package ru.romananchugov.vkmessenger.chats_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.romananchugov.domain.chats_list.ChatsListUseCase
import ru.romananchugov.vkmessenger.base_classes.BaseViewModel

class ChatsListViewModel(private val chatsListUseCase: ChatsListUseCase) : BaseViewModel() {
    private val _chatsList: MutableLiveData<List<ChatItem>> = MutableLiveData()
    val chatsList: LiveData<List<ChatItem>>
        get() = _chatsList

    fun onViewCreated() {
        _chatsList.postValue(chatsListUseCase.getChatsList().map { it.toUiData() })
    }

}