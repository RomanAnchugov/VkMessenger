package ru.romananchugov.vkmessenger.domain.chats_list

//Personal message model
data class VkMessageModel(
    val id: Int,
    val date: Int,
    val peerId: Int,
    val fromId: Int,
    val text: String
)