package jfyg.data.stat

import io.reactivex.Single

/**
 * https://etherscan.io/apis#stats
 */
internal interface StatsContract {

    /**
     * Get Total Supply of Ether
     */
    fun getTotalSupply(): Single<Double>

    /**
     * Get ETHER LastPrice Price in wei
     */
    fun getTotalSupplyInWei(): Single<Double>

    /**
     * Get ETHER LastPrice Price in btc
     */
    fun getLastPriceInBtc(): Single<Float>

    /**
     * Return timestamp
     */
    fun getBtcTimestamp(): Single<Long>

    /**
     * Get ETHER LastPrice Price in usd
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