object NetworkConfig {
    // Default IP address, you can set a default value or set it dynamically based on your needs
    private var ipAddress: String = "192.168.100.82"

    fun setIpAddress(ip: String) {
        ipAddress = ip
    }

    fun getBaseUrl(): String {

        return ipAddress
    }
}
