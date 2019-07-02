package ru.romananchugov.vkmessenger.chats_list

import com.vk.api.sdk.auth.VKAccessToken

sealed class AuthState {
    object StartAuth : AuthState()
    object AlreadyLoggedIn : AuthState()
    data class SuccessAuth(val token: VKAccessToken) : AuthState()
    data class ErrorAuth(val errorCode: Int) : AuthState()
}