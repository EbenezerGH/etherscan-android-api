package jfyg.data.stat

import io.reactivex.Single
import jfyg.data.StatPrice
import jfyg.network.queries.ApiQuery
import jfyg.utils.ETH_PRICE
import jfyg.utils.ETH_SUPPLY
import jfyg.utils.STATS

/**
 * https://etherscan.io/apis#stats
 */
class StatsApi : StatsContract {

    private val query = ApiQuery()
    private val supplyQuery = query.statSupply(STATS, ETH_SUPPLY)
    private val priceQuery = query.statPrice(STATS, ETH_PRICE)

    private val wei = 1000000000000000000 // 1 Ether is 1000000000000000000 Wei

    /**
     * Get Total Supply of Ether
     */
    override fun getTotalSupply(): Single<Double> = supplyQuery.map { it.result?.toDouble() }

    /**
     * Get ETHER LastPrice Price in wei
     */
    override fun getTotalSupplyInWei(): Single<Double> = supplyQuery.map { it.result?.toDouble()?.div(wei) }

    /**
     * Get Ether Statistics
     */
    override fun getEtherStatistics(): Single<StatPrice> = priceQuery.map { it.result }

    /**
     * Return network status
     */
    override fun getNetworkStatus(): Single<String> = priceQuery.map { it.status }

    /**
     * Return network message
     */
    override fun getNetworkMessage(): Single<String> = priceQuery.map { it.message }

}