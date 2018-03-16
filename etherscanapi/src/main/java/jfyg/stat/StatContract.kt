package jfyg.stat


interface StatContract {

    /**
     * Return Total Supply of Ether
     */
    fun getTotalSupply(): Int?

    /**
     * Return Total Supply of Ether in Wei
     */
    fun getTotalSupplyInWei(): Int?

    /**
     * Return Last price of ether in Btc
     */
    fun getLastPriceInBtc(): Float?

    /**
     * Return Timestamp
     */
    fun getBtcTimestamp(): Long?

    /**
     * Return Last price of ether in Usd
     */
    fun getLastPriceInUsd(): Float?

    /**
     * Return Timestamp
     */
    fun getEthTimestamp(): Long?

    /**
     * Return Network Status
     */
    fun getNetworkStatus(): String?

    /**
     * Return Network Message
     */
    fun getNetworkMessage(): String?

}