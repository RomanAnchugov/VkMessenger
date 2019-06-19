package ru.romananchugov.vkmessenger.base_classes

import androidx.lifecycle.ViewModel

open class BaseViewModel:ViewModel() {
    override fun onCleared() {
        super.onCleared()
    }
}