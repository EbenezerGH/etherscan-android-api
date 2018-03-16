package jfyg.stat

import jfyg.queries.Queries

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
        return query.fetchStatResponse()?.statResult?.ethUsd?.toFloat()
    }

    override fun getLastPriceInBtc(): Float? {

        query.stats("stats", "ethprice")
        return query.fetchStatResponse()?.statResult?.ethBtc?.toFloat()
    }

    override fun getNetworkStatus(): String? {

        query.stats("stats", "ethprice")
        return query.fetchStatResponse()?.status
    }

    override fun getNetworkMessage(): String? {

        query.stats("stats", "ethprice")
        return query.fetchStatResponse()?.message
    }

}