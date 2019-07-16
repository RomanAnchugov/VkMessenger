package ru.romananchugov.vkmessenger.domain.chats_list

//Настройки чата/беседы
data class VkChatSettingsModel(
    val membersCount: Int,
    val title: String,
    val pinnedMessage: VkPinnedMessageModel,
    val state: String,
    val photo: VkPhotoModel,
    val activeIds: List<Int>,
    val isGroupChannel: Boolean
)
