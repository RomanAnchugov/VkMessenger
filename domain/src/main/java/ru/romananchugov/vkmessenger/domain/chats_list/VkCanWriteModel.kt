package ru.romananchugov.vkmessenger.domain.chats_list

//Может ли пользователь писать
data class VkCanWriteModel(
    val allowed: Boolean,
    val reason: Int
)