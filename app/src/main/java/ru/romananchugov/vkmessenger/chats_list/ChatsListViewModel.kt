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

    private val _isLoggedIn: MutableLiveData<Boolean> = MutableLiveData()
    val isLoggedIn: LiveData<Boolean>
        get() = _isLoggedIn

    fun onViewCreated() {
        _chatsList.postValue(chatsListUseCase.getChatsList())
        _isLoggedIn.postValue(chatsListUseCase.isLoggedIn())
    }

}