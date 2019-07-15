package ru.romananchugov.vkmessenger.domain.chats_list

data class VkConversationWithMessageModel(
    val conversation: VkConversationModel,
    val message: VkMessageModel
)