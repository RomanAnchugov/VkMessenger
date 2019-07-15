package ru.romananchugov.vkmessenger.domain.chats_list

//Модель объекта беседы
data class VkConversationModel(
    val peer: VkPeerModel,
    val inRead: Int,
    val outRead: Int,
    val unreadCount: Int,
    val pushSettings: VkPushSettingsModel,
    val canWrite: VkCanWriteModel,
    val chatSettings: VkChatSettingsModel
)