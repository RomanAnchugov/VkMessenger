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


class MainActivity : BaseActivity(), AuthenticationListener {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun startAuth() {
        VK.login(this, listOf(VKScope.MESSAGES, VKScope.FRIENDS))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val callback = object : VKAuthCallback {
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

        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}