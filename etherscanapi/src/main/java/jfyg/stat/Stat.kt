package jfyg.stat

import jfyg.Queries

class Stat : StatContract {

    private var query = Queries()

    override fun getTotalSupply(): Int? {

        query.stats("stats", "ethsupply")
        return null //TODO: #26
    }

    override fun getTotalSupplyInWei(): Int? {

        query.stats("stats", "ethsupply")
        return null //TODO: #26
    }

    override fun getLastPriceInUsd(): Float? {

        query.stats("stats", "ethprice")
        return query.fetchStats()?.ethUsd?.toFloat()
    }

    override fun getLastPriceInBtc(): Float? {
        query.stats("stats", "ethprice")
        return query.fetchStats()?.ethBtc?.toFloat()
    }

}