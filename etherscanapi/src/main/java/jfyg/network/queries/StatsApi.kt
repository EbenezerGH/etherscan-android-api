package jfyg.network.queries

import io.reactivex.Single
import jfyg.network.response.StatPriceResponse
import jfyg.network.response.StatSupplyResponse

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