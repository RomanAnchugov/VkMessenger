package ru.romananchugov.vkmessenger.data.chats_list

import android.net.Uri
import ru.romananchugov.vkmessenger.domain.chats_list.ChatItem

data class ChatItemNW(
    val chatName: String = "Not Specified",
    val chatPreview: String = "Not specified",
    val chatImageUrl: Uri = Uri.EMPTY
)

fun ChatItemNW.toDomainItem(): ChatItem{
    return ChatItem(this.chatName, this.chatPreview, this.chatImageUrl)
}