package com.loka.pingapp.utils

import java.math.BigInteger
import java.net.Inet4Address
import java.net.Inet6Address
import java.net.InetAddress
import java.net.NetworkInterface

/**
 * Helper class for accessing device IP address.
 */
class Ip {
    companion object {
        /**
         * Get device IP address.
         * @param useIpV4 return IPv4 address.
         * @return device IP address.
         */
        fun address(useIpV4: Boolean = true): String {
            NetworkInterface.getNetworkInterfaces()?.toList()?.map { networkInterface ->
                networkInterface.inetAddresses?.toList()?.find { inetAddress ->
                    !inetAddress.isLoopbackAddress
                            &&
                            ((useIpV4 && inetAddress is Inet4Address) // select IpV4 address
                            || (!useIpV4 && inetAddress is Inet6Address)) // select IpV6 address
                }?.let { inetAddress ->
                    val hostAddress = inetAddress.hostAddress

                    if (hostAddress.isNullOrBlank()) return "" // blank IP
                    if (useIpV4) return hostAddress // IpV4

                    val zoneSuffixIndex = hostAddress.indexOf('%')

                    return if (zoneSuffixIndex < 0) // Ipv6
                        hostAddress.uppercase()
                    else
                        hostAddress.substring(0, zoneSuffixIndex).uppercase()
                }
            }

            return ""
        }

        /**
         * Convert integer to InetAddress.
         * @param address integer that stores ip address.
         * @return inet address.
         */
        fun intToInetAddress(address: Int): InetAddress {
            return InetAddress.getByAddress(
                BigInteger.valueOf(address.toLong()
                ).toByteArray().reversedArray())
        }
    }
}