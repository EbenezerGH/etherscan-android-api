package jfyg.network.queries

import io.reactivex.Single
import jfyg.network.response.stat.StatPriceResponse
import jfyg.network.response.stat.StatSupplyResponse

internal interface StatsApi {

    /**
     * Get ETHER LastPrice
     */
    fun statPrice(module: String,
                  action: String): Single<StatPriceResponse>

    /**
     * Get Total Supply of Ether
     */
    fun statSupply(module: String,
                   action: String): Single<StatSupplyResponse>

}