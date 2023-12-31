package com.example.myapplication

import java.net.InetAddress
import java.net.NetworkInterface

class IP {
    fun getIpv4Address(): String {
        var ipv4Address = "Unknown"

        try {
            val interfaces = NetworkInterface.getNetworkInterfaces()
            while (interfaces.hasMoreElements()) {
                val networkInterface = interfaces.nextElement()
                val addresses = networkInterface.inetAddresses

                while (addresses.hasMoreElements()) {
                    val address = addresses.nextElement()
                    if (!address.isLoopbackAddress && address is InetAddress && address.hostAddress.contains(
                            "."
                        )
                    ) {
                        // Check if the address is IPv4
                        ipv4Address = address.hostAddress
                    }
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ipv4Address
    }
}

fun main() {
    val ip = IP()
    val ipv4Address = ip.getIpv4Address()
    println("Device IPv4 Address: $ipv4Address")
}
