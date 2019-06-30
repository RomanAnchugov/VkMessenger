package ru.romananchugov.vkmessenger.chats_list

import com.vk.api.sdk.auth.VKAccessToken

sealed class AuthState {
    object StartLogin : AuthState()
    data class Success(val token: VKAccessToken) : AuthState()
    data class Error(val errorCode: Int) : AuthState()
}