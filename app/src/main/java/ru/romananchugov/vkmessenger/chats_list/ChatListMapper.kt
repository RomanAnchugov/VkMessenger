package ru.romananchugov.vkmessenger.chats_list

import ru.romananchugov.data.chats_list.ChatItem

fun ChatItem.toUiData(): ru.romananchugov.vkmessenger.chats_list.ChatItem {
    return ru.romananchugov.vkmessenger.chats_list.ChatItem(this.chatName, this.latestMessagePreview, this.imageUrl)
}