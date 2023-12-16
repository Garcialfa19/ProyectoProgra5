object NetworkConfig {
    // Default IP address, you can set a default value or set it dynamically based on your needs
    private var ipAddress: String = "192.168.0.109"

    fun setIpAddress(ip: String) {
        ipAddress = ip
    }

    fun getBaseUrl(): String {

        return ipAddress
    }
}
