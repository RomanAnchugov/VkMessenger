package ru.romananchugov.vkmessenger.domain.chats_list


//WIP
data class VkConversationsResponseModel(
    val count: Int,
    val items: List<VkConversationWithMessageModel>,
    val unreadCount: Int
)
