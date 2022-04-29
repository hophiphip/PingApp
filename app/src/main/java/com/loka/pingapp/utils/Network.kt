package com.loka.pingapp.utils

import android.content.Context
import android.net.*
import android.net.Network
import android.net.wifi.WifiManager
import android.util.Log
import android.widget.Toast


class Network {
    companion object {
        private const val TAG = "Network"

        fun request(): NetworkRequest {
            return NetworkRequest.Builder()
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
                .build()
        }

        fun callback(context: Context): ConnectivityManager.NetworkCallback {
            return object : ConnectivityManager.NetworkCallback() {

                override fun onAvailable(network: Network) {
                    super.onAvailable(network)

                    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                    val networkCapabilities = connectivityManager.getNetworkCapabilities(network)

                    if (networkCapabilities != null) {
                        when {
                            networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                                val wifiManager = context.applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
                                val wifiInfo = wifiManager.connectionInfo
                                val dhcpInfo = wifiManager.dhcpInfo

                                val gatewayAddress = Ip.intToInetAddress(dhcpInfo.gateway)
                                val ipAddress = Ip.intToInetAddress(dhcpInfo.ipAddress)
                                val serverAddress = Ip.intToInetAddress(dhcpInfo.serverAddress)

                                Log.i(TAG, "${gatewayAddress.hostAddress ?: 0}")
                                Log.i(TAG, "${ipAddress.hostAddress ?: 0}")
                                Log.i(TAG, "${serverAddress.hostAddress ?: 0}")
                            }
                        }
                    }

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