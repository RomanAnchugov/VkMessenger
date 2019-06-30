package ru.romananchugov.vkmessenger.utils

import androidx.fragment.app.Fragment

inline fun <reified T> Fragment.possibleListeners() : List<T>{
    val list = mutableListOf<T>()
    if(activity is T) list.add(activity as T)
    if(parentFragment is T) list.add(activity as T)
    if(targetFragment is T) list.add(activity as T)
    return list
}