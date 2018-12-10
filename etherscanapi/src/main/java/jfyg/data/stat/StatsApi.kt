package jfyg.data.stat

import jfyg.network.queries.ApiQuery
import jfyg.network.response.StatPriceResponse
import jfyg.network.response.StatSupplyResponse
import jfyg.utils.ETH_PRICE
import jfyg.utils.ETH_SUPPLY
import jfyg.utils.STATS
import retrofit2.Response

/**
 * https://etherscan.io/apis#stats
 */
class StatsApi : StatsContract {

    private val query = ApiQuery()

    /**
     * Get Total Supply of Ether
     *
     * Getting response in wei will require a conversion
     *
     * EG:
     * val wei = 1000000000000000000 // 1 Ether is 1000000000000000000 Wei
     * result.toDouble().div(wei)
     */
    override suspend fun getEtherTotalSupply(): Response<StatSupplyResponse> = query.statSupply(STATS, ETH_SUPPLY)
    /**
     * Get Ether Statistics
     */
    override suspend fun getEtherStatistics(): Response<StatPriceResponse> = query.statPrice(STATS, ETH_PRICE)

    /**
     * Return network status
     */
    override suspend fun getNetworkStatus(): Response<StatPriceResponse> = query.statPrice(STATS, ETH_PRICE)

    /**
     * Return network message
     */
    override suspend fun getNetworkMessage(): Response<StatPriceResponse> = query.statPrice(STATS, ETH_PRICE)

}