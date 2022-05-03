package com.loka.pingapp.models

/**
 * Network represents specific network.
 *
 * @property name Network name. In current case it is WiFi AP SSID.
 * @property gatewayAddress Gateway IP address of the network.
 * @property clientAddress IP Address of a client connected to network.
 * @property hosts A list of hosts to monitor their status (Up/Down).
 */
data class Network(val name: String, val gatewayAddress: String, val clientAddress: String, val hosts: MutableList<Host>) {}