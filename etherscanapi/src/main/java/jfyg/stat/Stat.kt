package jfyg.stat

import jfyg.queries.QueryMediator

class Stat : StatContract {

    private val query = QueryMediator()
    private val supplyQuery = query.statSupply("stats", "ethsupply")
    private val priceQuery = query.statPrice("stats", "ethprice")

    private val wei = 1000000000000000000 // 1 Ether is 1000000000000000000 Wei

    override fun getTotalSupply(): Double? = supplyQuery.let { query.fetchStatSupply()?.result?.toDouble() }

    override fun getTotalSupplyInWei(): Double? = supplyQuery.let { query.fetchStatSupply()?.result?.toDouble()?.div(wei) }

    override fun getLastPriceInUsd(): Float? = priceQuery.let { query.fetchStatPrice()?.result?.ethUsd?.toFloat() }

    override fun getEthTimestamp(): Long? = priceQuery.let { query.fetchStatPrice()?.result?.ethUsdTimestamp?.toLong() }

    override fun getLastPriceInBtc(): Float? = priceQuery.let { query.fetchStatPrice()?.result?.ethBtc?.toFloat() }

    override fun getBtcTimestamp(): Long? = priceQuery.let { query.fetchStatPrice()?.result?.ethBtcTimestamp?.toLong() }

    override fun getNetworkStatus(): String? = priceQuery.let { query.fetchStatPrice()?.status }

    override fun getNetworkMessage(): String? = priceQuery.let { query.fetchStatPrice()?.message }

}