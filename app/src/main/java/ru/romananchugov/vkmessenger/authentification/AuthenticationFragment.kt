package ru.romananchugov.vkmessenger.authentification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.vk.api.sdk.auth.VKAccessToken
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.romananchugov.vkmessenger.R
import ru.romananchugov.vkmessenger.base_classes.BaseFragment
import ru.romananchugov.vkmessenger.chats_list.AuthState
import ru.romananchugov.vkmessenger.utils.possibleListeners
import timber.log.Timber


class AuthenticationFragment : BaseFragment() {
    private val authViewModel: AuthenticationViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_authentification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel.authState.observe(this, Observer {
            when (it) {
                is AuthState.StartLogin -> startAuth()
                is AuthState.Success -> Timber.i("Succes state")
                is AuthState.Error -> Timber.i("Error state")
            }
        })
        authViewModel.onViewCreated()
    }

    private fun startAuth() {
        possibleListeners<AuthenticationListener>().forEach {
            it.startAuth()
        }
    }

    fun authSuccessFromActivity(token: VKAccessToken) {
        authViewModel.authPassed(token)
    }

    fun authFailedFromActivity(errorCode: Int) {
        authViewModel.authFailed(errorCode)
    }


}
