package jfyg.etherscan.helloetherescan.ethereum


import android.util.Log
import jfyg.etherscan.helloetherescan.MainActivity

class EthereumStat : EthereumStatFunctions {

    var activity = MainActivity()

    override fun getTotalSupply(): Long? {
        val stats = "stats"
        val ethSupply = "ethSupply"

        activity.queryStats(stats, ethSupply)
        return 0 //TODO: Figure out how to parse supply
    }


    override fun getTotalSupplyInWei(): Int? {
        val stats = "stats"
        val ethSupply = "ethSupply"

        activity.queryStats(stats, ethSupply)
        return 0 //TODO: Figure out how to parse supply
    }

    override fun getLastPriceInUsd(): String? {
        val stats = "stats"
        val ethPrice = "ethprice"

        activity.queryStats(stats, ethPrice)
        Log.d("Ebenezer", activity.etherPrice.ethUsd)
        return activity.etherPrice.ethUsd //TODO: Make this return Int
    }

    override fun getLastPriceInBtc(): String? {
        val stats = "stats"
        val ethPrice = "ethprice"

        activity.queryStats(stats, ethPrice)
        Log.d("Ebenezer", activity.etherPrice.ethBtc)
        return activity.etherPrice.ethBtc //TODO: Make this return Int
    }

}