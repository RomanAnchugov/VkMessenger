package ru.romananchugov.vkmessenger

import android.content.Intent
import android.os.Bundle
import com.vk.api.sdk.VK
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import ru.romananchugov.vkmessenger.authentification.AuthenticationFragment
import ru.romananchugov.vkmessenger.authentification.AuthenticationListener
import ru.romananchugov.vkmessenger.base_classes.BaseActivity
import timber.log.Timber


class MainActivity : BaseActivity(), AuthenticationListener {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val vkAuthCallback = object : VKAuthCallback {
        override fun onLogin(token: VKAccessToken) {
            // User passed authorization
            supportFragmentManager.fragments[0].childFragmentManager.fragments.forEach {
                if (it is AuthenticationFragment) {
                    it.authSuccessFromActivity(token)
                }
            }
        }

        override fun onLoginFailed(errorCode: Int) {
            supportFragmentManager.fragments[0].childFragmentManager.fragments.forEach {
                if (it is AuthenticationFragment) {
                    it.authFailedFromActivity(errorCode)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun startAuth() {
        VK.login(this, listOf(VKScope.MESSAGES, VKScope.FRIENDS))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        Timber.i("OnActivity Result")


        //Если пользователь закрыл браузер или что-то пошло не так при логине в вк
        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, vkAuthCallback)) {
            super.onActivityResult(requestCode, resultCode, data)
            supportFragmentManager.fragments[0].childFragmentManager.fragments.forEach {
                if (it is AuthenticationFragment) {
                    it.authInterruptedFromActivity()
                }
            }
        }
    }
}