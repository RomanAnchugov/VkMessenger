package ru.romananchugov.vkmessenger.base_classes

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel

open class BaseViewModel:ViewModel() {

    protected val scope = CoroutineScope(Job() + Dispatchers.Main)

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}