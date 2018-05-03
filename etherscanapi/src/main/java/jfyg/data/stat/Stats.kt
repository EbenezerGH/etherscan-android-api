package jfyg.data.stat

import io.reactivex.Single
import jfyg.network.queries.ApiQuery
import jfyg.utils.ETH_PRICE
import jfyg.utils.ETH_SUPPLY
import jfyg.utils.STATS

/**
 * https://etherscan.io/apis#stats
 */
class Stats : StatsContract {

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
     * Get ETHER LastPrice Price in btc
     */
    override fun getLastPriceInUsd(): Single<Float> = priceQuery.map { it.result?.ethUsd?.toFloat() }

    /**
     * Return timestamp
     */
    override fun getEthTimestamp(): Single<Long> = priceQuery.map { it.result?.ethUsdTimestamp?.toLong() }

    /**
     * Get ETHER LastPrice Price in usd
     */
    override fun getLastPriceInBtc(): Single<Float> = priceQuery.map { it.result?.ethBtcTimestamp?.toFloat() }

    /**
     * Return timestamp
     */
    override fun getBtcTimestamp(): Single<Long> = priceQuery.map { it.result?.ethBtcTimestamp?.toLong() }

    /**
     * Return network status
     */
    override fun getNetworkStatus(): Single<String> = priceQuery.map { it.status }

    /**
     * Return network message
     */
    override fun getNetworkMessage(): Single<String> = priceQuery.map { it.message }

}