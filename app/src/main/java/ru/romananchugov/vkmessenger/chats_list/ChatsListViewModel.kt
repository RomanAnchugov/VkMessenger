package ru.romananchugov.vkmessenger.chats_list

import androidx.lifecycle.ViewModel
import timber.log.Timber

class ChatsListViewModel: ViewModel() {

    fun test(){
        Timber.i("Test method()")
    }

    override fun onCleared() {
        super.onCleared()
    }
}