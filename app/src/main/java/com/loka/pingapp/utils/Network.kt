package com.loka.pingapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.widget.Toast

class Network {
    companion object {
        fun request(): NetworkRequest {
            return NetworkRequest.Builder()
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .build()
        }

        fun callback(context: Context): ConnectivityManager.NetworkCallback {
            return object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)

                    Toast.makeText(context, "Wifi is on", Toast.LENGTH_SHORT).show()
                }

                override fun onLost(network: Network) {
                    super.onLost(network)

                    Toast.makeText(context, "Wifi is off", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}