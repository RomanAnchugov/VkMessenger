package ru.romananchugov.vkmessenger.utils

import android.app.Application
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkInfo
import android.os.Build
import androidx.lifecycle.LiveData


object InternetUtils : LiveData<Boolean>() {
    private var broadcastReceiver: BroadcastReceiver? = null
    private lateinit var application: Application
    private lateinit var cm: ConnectivityManager

    private var isAvailable: Boolean = false

    fun init(application: Application) {
        this.application = application
        cm = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    fun isInternetOn(): Boolean {
        val activeNetwork = cm.activeNetworkInfo
        isAvailable = activeNetwork != null && activeNetwork.isConnectedOrConnecting
        return isAvailable
    }

    override fun onActive() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            cm.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network?) {
                    super.onAvailable(network)
                    value = true
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    value = false
                }

                override fun onLost(network: Network?) {
                    super.onLost(network)
                    value = false
                }
            })
        } else {
            registerBroadCastReceiver()
        }
    }

    override fun onInactive() {
        unRegisterBroadCastReceiver()
    }

    private fun registerBroadCastReceiver() {
        if (broadcastReceiver == null) {
            val filter = IntentFilter()
            filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)

            broadcastReceiver = object : BroadcastReceiver() {
                override fun onReceive(_context: Context, intent: Intent) {
                    val extras = intent.extras
                    val info = extras.getParcelable<NetworkInfo>("networkInfo")
                    value = info.state == NetworkInfo.State.CONNECTED
                }
            }


            application.registerReceiver(broadcastReceiver, filter)
        }
    }

    private fun unRegisterBroadCastReceiver() {
        if (broadcastReceiver != null) {
            application.unregisterReceiver(broadcastReceiver)
            broadcastReceiver = null
        }
    }
}