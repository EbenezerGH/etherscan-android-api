package jfyg.data.stat

import io.reactivex.Single

/**
 * https://etherscan.io/apis#stats
 */
internal interface StatContract {

    /**
     * Return total supply of ether
     */
    fun getTotalSupply(): Single<Double>

    /**
     * Return total supply of ether in wei
     */
    fun getTotalSupplyInWei(): Single<Double>

    /**
     * Return last price of ether in btc
     */
    fun getLastPriceInBtc(): Single<Float>

    /**
     * Return timestamp
     */
    fun getBtcTimestamp(): Single<Long>

    /**
     * Return last price of ether in usd
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