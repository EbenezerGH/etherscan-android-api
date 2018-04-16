package jfyg.stat

import io.reactivex.Single

internal interface StatContract {

    /**
     * Return total supply of Ether
     */
    fun getTotalSupply(): Single<Double>

    /**
     * Return total supply of Ether in Wei
     */
    fun getTotalSupplyInWei(): Single<Double>

    /**
     * Return last price of Ether in Btc
     */
    fun getLastPriceInBtc(): Single<Float>

    /**
     * Return timestamp
     */
    fun getBtcTimestamp(): Single<Long>

    /**
     * Return last price of Ether in Usd
     */
    fun getLastPriceInUsd(): Single<Float>

    /**
     * Return timestamp
     */
    fun getEthTimestamp(): Single<Long>

    /**
     * Return network status
     */
    fun getNetworkStatus(): Single<String>

    /**
     * Return network message
     */
    fun getNetworkMessage(): Single<String>

}