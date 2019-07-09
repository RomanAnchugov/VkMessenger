package ru.romananchugov.vkmessenger.domain.chats_list

import android.net.Uri

data class ChatItem(
    val chatName: String = "Not Specified",
    val chatPreview: String = "Not specified",
    val chatImageUrl: Uri = Uri.EMPTY
)