package ru.romananchugov.vkmessenger.authentification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.vk.api.sdk.auth.VKAccessToken
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.romananchugov.vkmessenger.R
import ru.romananchugov.vkmessenger.base_classes.BaseFragment
import ru.romananchugov.vkmessenger.utils.InternetUtils
import ru.romananchugov.vkmessenger.utils.possibleListeners


class AuthenticationFragment : BaseFragment() {

    companion object {
        private const val TAG = "AuthenticationFragment"
    }

    private val authViewModel: AuthenticationViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_authentification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel.authState.observe(this, Observer {
            handleState(it)
        })

        authViewModel.onViewCreated()
    }

    private fun handleState(authState: AuthState) = when (authState) {
        is AuthState.StartAuth -> startAuth()
        is AuthState.AlreadyLoggedIn -> navigateToChatsListScreen()
        is AuthState.SuccessAuth -> navigateToChatsListScreen()
        is AuthState.ErrorAuth -> showError()
    }

    private fun startAuth() {
        if (InternetUtils.isInternetOn()) {
            possibleListeners<AuthenticationListener>().forEach {
                it.startAuth()
            }
        } else {
            showError()
        }
    }

    private fun navigateToChatsListScreen() {
        findNavController(this).navigate(R.id.action_authenticationFragment_to_chatsListFragment)
    }

    private fun showError() {
        view?.let {
            Snackbar
                .make(it, getString(R.string.sth_went_wrong), Snackbar.LENGTH_INDEFINITE)
                .setActionTextColor(ContextCompat.getColor(requireContext() ,R.color.errorSnackColor))
                .setAction(getString(R.string.retry)) {
                    authViewModel.onErrorSnackClicked()
                }.show()
        }
    }

    fun authSuccessFromActivity(token: VKAccessToken) {
        authViewModel.authPassed(token)
    }

    fun authFailedFromActivity(errorCode: Int) {
        authViewModel.authFailed(errorCode)
    }

    fun authInterruptedFromActivity() {
        showError()
    }


}
