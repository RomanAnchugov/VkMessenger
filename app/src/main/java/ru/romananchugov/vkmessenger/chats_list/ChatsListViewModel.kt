package ru.romananchugov.vkmessenger.chats_list

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.romananchugov.vkmessenger.base_classes.BaseViewModel
import timber.log.Timber

class ChatsListViewModel: BaseViewModel() {

    fun test(){
        Timber.i("Test method()")
        scope.launch {
            delay(1000)
            Timber.i("Test coroutine()")
        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}