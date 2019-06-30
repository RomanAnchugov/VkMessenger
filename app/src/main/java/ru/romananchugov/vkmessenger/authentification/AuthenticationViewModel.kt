package ru.romananchugov.vkmessenger.authentification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import ru.romananchugov.vkmessenger.base_classes.BaseViewModel
import ru.romananchugov.vkmessenger.chats_list.AuthState
import timber.log.Timber

class AuthenticationViewModel : BaseViewModel() {

    companion object {
        private const val TAG = "AuthenticationViewModel"
    }

    private var _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState>
        get() = _authState

    fun onViewCreated() {
        if (VK.isLoggedIn()) {
            Timber.i("User logged in")
        } else {
            Timber.i("User NOT logged in")
            performLogin()
        }
    }

    fun authPassed(token: VKAccessToken) {
        Timber.i("Authntication successfuly passed; toke $token")
        _authState.value = AuthState.Success(token)
    }

    fun authFailed(errorCode: Int) {
        Timber.i("Authntication failed; error code $errorCode")
        _authState.value = AuthState.Error(errorCode)
    }

    private fun performLogin() {
        Timber.i("Started loggining")
        _authState.value = AuthState.ProcessAuth
    }
}