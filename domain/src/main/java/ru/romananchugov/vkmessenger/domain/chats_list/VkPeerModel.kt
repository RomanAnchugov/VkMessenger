package ru.romananchugov.vkmessenger.domain.chats_list

//Модель объекта собеседника
data class VkPeerModel(
    val id: Int,
    val type: String,
    val localId: Int
)