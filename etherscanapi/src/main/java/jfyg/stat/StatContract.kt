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
     * Return Last price of ether in Usd
     */
    fun getLastPriceInUsd(): Float?

    /**
     * Return Network Status and Message
     */
    fun getNetworkStatus(): String?

}