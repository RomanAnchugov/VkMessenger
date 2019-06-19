package ru.romananchugov.vkmessenger

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import com.vk.api.sdk.auth.VKScope
import com.vk.api.sdk.exceptions.VKApiExecutionException
import com.vk.sdk.sample.models.VKUser
import com.vk.sdk.sample.requests.VKFriendsRequest
import ru.romananchugov.vkmessenger.base_classes.BaseActivity
import timber.log.Timber


class MainActivity : BaseActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (VK.isLoggedIn()) {
            VK.login(this, arrayListOf(VKScope.WALL, VKScope.PHOTOS, VKScope.MESSAGES))
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Timber.tag(TAG).i("On activity result")

        val callback = object : VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                Timber.tag(TAG).i("Logging successful")

                VK.execute(VKFriendsRequest(), object: VKApiCallback<List<VKUser>> {
                    override fun success(result: List<VKUser>) {
                        if (!isFinishing && result.isNotEmpty()) {
                            //showFriends(result)
                            result.forEach {
                                Timber.tag(TAG).i("User is ${it.firstName}")
                            }
                        }
                    }
                    override fun fail(error: VKApiExecutionException) {
                        Log.e(TAG, error.toString())
                    }
                })
            }

            override fun onLoginFailed(errorCode: Int) {
                Timber.tag(TAG).i("Logging failed")
            }
        }

        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}