package jfyg.network.queries

import io.reactivex.Single
import jfyg.network.response.stat.StatPriceResponse
import jfyg.network.response.stat.StatSupplyResponse

internal interface StatApi {

    /**
     * Get ether last price
     */
    fun statPrice(module: String, action: String): Single<StatPriceResponse>

    /**
     * Get total supply of ether
     */
    fun statSupply(module: String, action: String): Single<StatSupplyResponse>

}