package jfyg.data.stat

import jfyg.network.response.StatPriceResponse
import jfyg.network.response.StatSupplyResponse
import retrofit2.Response

/**
 * https://etherscan.io/apis#stats
 */
internal interface StatsContract {

    /**
     * Get Total Supply of Ether
     */
    suspend fun getEtherTotalSupply(): Response<StatSupplyResponse>
    /**
     * Get ETHER statistics
     */
    suspend fun getEtherStatistics(): Response<StatPriceResponse>

    /**
     * Return network status
     */
    suspend fun getNetworkStatus(): Response<StatPriceResponse>

    /**
     * Return network message
     */
    suspend fun getNetworkMessage(): Response<StatPriceResponse>

}