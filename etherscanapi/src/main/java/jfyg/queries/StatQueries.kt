package jfyg.queries

import io.reactivex.Single
import jfyg.response.stat.StatPriceResponse
import jfyg.response.stat.StatSupplyResponse

internal interface StatQueries {

    /**
     * Get ether last price
     */
    fun statPrice(module: String, action: String): Single<StatPriceResponse>

    /**
     * Get total supply of ether
     */
    fun statSupply(module: String, action: String): Single<StatSupplyResponse>

}