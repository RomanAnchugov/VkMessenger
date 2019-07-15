package ru.romananchugov.vkmessenger.domain.chats_list

//Объект настроек уведомлений
data class VkPushSettingsModel(
    val disabledUntil: Int,
    val disabledForever: Boolean,
    val oSound: Boolean
)
