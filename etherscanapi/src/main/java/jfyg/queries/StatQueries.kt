package jfyg.queries

import io.reactivex.disposables.Disposable
import jfyg.response.stat.StatPriceResponse
import jfyg.response.stat.StatSupplyResponse

internal interface StatQueries {

    /**
     * Get Ether last price
     */
    fun statPrice(module: String, action: String): Disposable?

    /**
     * Get total supply of Ether
     */
    fun statSupply(module: String, action: String): Disposable?

    fun handleResponse(response: StatPriceResponse)

    fun handleResponse(response: StatSupplyResponse)

}