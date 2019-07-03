package ru.romananchugov.vkmessenger.authentification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import ru.romananchugov.vkmessenger.base_classes.BaseViewModel
import timber.log.Timber



class AuthenticationViewModel : BaseViewModel() {

    companion object {
        private const val TAG = "AuthenticationViewModel"
    }

    private var _authState = MutableLiveData<AuthState>()
    val authState: LiveData<AuthState>
        get() = _authState

    private fun performLogin() {
        Timber.i("Started loggining")
        _authState.value = AuthState.StartAuth
    }

    fun onViewCreated() {
        //TEST
        //VK.logout()

        if (VK.isLoggedIn()) {
            Timber.i("User logged in")
            _authState.value = AuthState.AlreadyLoggedIn
        } else {
            Timber.i("User NOT logged in")
            performLogin()
        }
    }

    fun authPassed(token: VKAccessToken) {
        Timber.i("Authntication successfuly passed; toke $token")
        _authState.value = AuthState.SuccessAuth(token)
    }

    fun authFailed(errorCode: Int) {
        Timber.i("Authntication failed; error code $errorCode")
        _authState.value = AuthState.ErrorAuth(errorCode)
    }
    fun onErrorSnackClicked() {
        Timber.i("On error snack clicked")
        performLogin()
    }

}