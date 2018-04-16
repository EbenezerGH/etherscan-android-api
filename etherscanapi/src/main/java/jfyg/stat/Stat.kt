package jfyg.stat

import io.reactivex.Single
import jfyg.queries.QueryMediator

class Stat : StatContract {

    private val query = QueryMediator()
    private val supplyQuery = query.statSupply("stats", "ethsupply")
    private val priceQuery = query.statPrice("stats", "ethprice")

    private val wei = 1000000000000000000 // 1 Ether is 1000000000000000000 Wei

    override fun getTotalSupply(): Single<Double>? = supplyQuery?.map { it.result?.toDouble() }

    override fun getTotalSupplyInWei(): Single<Double>? = supplyQuery?.map { it.result?.toDouble()?.div(wei) }

    override fun getLastPriceInUsd(): Single<Float>? = priceQuery?.map { it.result?.ethUsd?.toFloat() }

    override fun getEthTimestamp(): Single<Long>? = priceQuery?.map { it.result?.ethUsdTimestamp?.toLong() }

    override fun getLastPriceInBtc(): Single<Float>? = priceQuery?.map { it.result?.ethBtcTimestamp?.toFloat() }

    override fun getBtcTimestamp(): Single<Long>? = priceQuery?.map { it.result?.ethBtcTimestamp?.toLong() }

    override fun getNetworkStatus(): Single<String>? = priceQuery?.map { it.status }

    override fun getNetworkMessage(): Single<String>? = priceQuery?.map { it.message }

}