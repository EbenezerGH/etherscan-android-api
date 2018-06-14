package jfyg.data.stat

import io.reactivex.Single
import jfyg.data.StatPrice

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
     * Get ETHER statistics
     */
    fun getEtherStatistics(): Single<StatPrice>

    /**
     * Return network status
     */
    fun getNetworkStatus(): Single<String>

    /**
     * Return network message
     */
    fun getNetworkMessage(): Single<String>

}