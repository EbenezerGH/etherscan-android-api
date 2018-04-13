package jfyg.stat

internal interface StatContract {

    /**
     * Return total supply of Ether
     */
    fun getTotalSupply(): Double?

    /**
     * Return total supply of Ether in Wei
     */
    fun getTotalSupplyInWei(): Double?

    /**
     * Return last price of Ether in Btc
     */
    fun getLastPriceInBtc(): Float?

    /**
     * Return timestamp
     */
    fun getBtcTimestamp(): Long?

    /**
     * Return last price of Ether in Usd
     */
    fun getLastPriceInUsd(): Float?

    /**
     * Return timestamp
     */
    fun getEthTimestamp(): Long?

    /**
     * Return network status
     */
    fun getNetworkStatus(): String?

    /**
     * Return network message
     */
    fun getNetworkMessage(): String?

}