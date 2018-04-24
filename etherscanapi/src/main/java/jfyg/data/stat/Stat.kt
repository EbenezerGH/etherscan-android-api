package jfyg.data.stat

import io.reactivex.Single
import jfyg.network.queries.ApiQuery

/**
 * https://etherscan.io/apis#stats
 */
class Stat : StatContract {

    private val query = ApiQuery()
    private val supplyQuery = query.statSupply("stats", "ethsupply")
    private val priceQuery = query.statPrice("stats", "ethprice")

    private val wei = 1000000000000000000 // 1 Ether is 1000000000000000000 Wei

    /**
     * Return total supply of ether
     */
    override fun getTotalSupply(): Single<Double> = supplyQuery.map { it.result?.toDouble() }

    /**
     * Return total supply of ether in wei
     */
    override fun getTotalSupplyInWei(): Single<Double> = supplyQuery.map { it.result?.toDouble()?.div(wei) }

    /**
     * Return last price of ether in btc
     */
    override fun getLastPriceInUsd(): Single<Float> = priceQuery.map { it.result?.ethUsd?.toFloat() }

    /**
     * Return timestamp
     */
    override fun getEthTimestamp(): Single<Long> = priceQuery.map { it.result?.ethUsdTimestamp?.toLong() }

    /**
     * Return last price of ether in usd
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