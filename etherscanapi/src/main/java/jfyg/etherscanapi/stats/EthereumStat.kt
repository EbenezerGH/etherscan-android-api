package jfyg.etherscanapi.stats

import jfyg.etherscanapi.Queries


class EthereumStat : EthereumStatFunctions {

    private var query = Queries()

    override fun getTotalSupply(): Long? {
        val stats = "stats"
        val ethSupply = "ethSupply"

        query.stats(stats, ethSupply)
        return 0 //TODO: Figure out how to parse supply
    }


    override fun getTotalSupplyInWei(): Int? {
        val stats = "stats"
        val ethSupply = "ethSupply"

        query.stats(stats, ethSupply)
        return 0 //TODO: Figure out how to parse supply
    }

    override fun getLastPriceInUsd(): String? {
        val stats = "stats"
        val ethPrice = "ethprice"

        query.stats(stats, ethPrice)
        return query.fetchEtherStats().ethUsd //TODO: Make this return Int
    }

    override fun getLastPriceInBtc(): String? {
        val stats = "stats"
        val ethPrice = "ethprice"

        query.stats(stats, ethPrice)
        return query.fetchEtherStats().ethBtc //TODO: Make this return Int
    }

}