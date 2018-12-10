package jfyg.network.queries

import jfyg.network.response.StatPriceResponse
import jfyg.network.response.StatSupplyResponse
import retrofit2.Response

internal interface StatsApi {

    /**
     * Get ETHER LastPrice
     */
    suspend fun statPrice(module: String,
                  action: String): Response<StatPriceResponse>

    /**
     * Get Total Supply of Ether
     */
    suspend fun statSupply(module: String,
                   action: String): Response<StatSupplyResponse>

}