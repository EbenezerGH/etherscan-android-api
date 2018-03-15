package jfyg.stat


interface EthereumStatFunctions {

    /**
     * Return Total Supply of Ether
     */
    fun getTotalSupply(): Long?

    /**
     * Return Total Supply of Ether in Wei
     */
    fun getTotalSupplyInWei(): Int?

    /**
     * Return Last price of ether in Btc
     */
    fun getLastPriceInBtc(): String?

    /**
     * Return Last price of ether in Usd
     */
    fun getLastPriceInUsd(): String?

}