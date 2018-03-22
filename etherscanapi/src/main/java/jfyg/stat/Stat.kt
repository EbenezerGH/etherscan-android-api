package jfyg.stat

import jfyg.queries.QueryMediator

class Stat : StatContract {

    private var query = QueryMediator()

    override fun getTotalSupply(): Double? {

        query.statSupply("stats", "ethsupply")
        return query.fetchStatSupply()?.result?.toDouble()
    }

    override fun getTotalSupplyInWei(): Double? {

        query.statSupply("stats", "ethsupply")
        return (query.fetchStatSupply()?.result?.toDouble()?.div(1000000000000000000))
    }

    override fun getLastPriceInUsd(): Float? {

        query.statPrice("stats", "ethprice")
        return query.fetchStatPrice()?.result?.ethUsd?.toFloat()
    }

    override fun getEthTimestamp(): Long? {

        query.statPrice("stats", "ethprice")
        return query.fetchStatPrice()?.result?.ethUsdTimestamp?.toLong()
    }

    override fun getLastPriceInBtc(): Float? {

        query.statPrice("stats", "ethprice")
        return query.fetchStatPrice()?.result?.ethBtc?.toFloat()
    }

    override fun getBtcTimestamp(): Long? {

        query.statPrice("stats", "ethprice")
        return query.fetchStatPrice()?.result?.ethBtcTimestamp?.toLong()
    }

    override fun getNetworkStatus(): String? {

        query.statPrice("stats", "ethprice")
        return query.fetchStatPrice()?.status
    }

    override fun getNetworkMessage(): String? {

        query.statPrice("stats", "ethprice")
        return query.fetchStatPrice()?.message
    }

}