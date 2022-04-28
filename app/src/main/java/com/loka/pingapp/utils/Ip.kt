package com.loka.pingapp.utils

import java.lang.Exception
import java.net.InetAddress
import java.net.NetworkInterface
import java.util.*

class Ip {
    companion object {
        fun address(useIpV4: Boolean): String? {
            try {
                val interfaces: List<NetworkInterface> = Collections.list(NetworkInterface.getNetworkInterfaces())

                interfaces.forEach { iface ->
                    val addresses: List<InetAddress> = Collections.list(iface.inetAddresses)

                    addresses.forEach { address ->
                        if (!address.isLoopbackAddress) {
                            val hostAddress = address.hostAddress

                            if (hostAddress != null) {
                                val isHostAddressIpV4 = hostAddress.indexOf(':') < 0

                                if (useIpV4) {

                                }
                            }
                        }
                    }
                }

                return null
            } catch (ex: Exception) {
                return null
            }
        }
    }
}