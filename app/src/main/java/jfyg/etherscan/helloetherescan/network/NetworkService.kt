package jfyg.etherscan.helloetherescan.network

import io.reactivex.Observable
import jfyg.etherscan.helloetherescan.model.EtherPrice
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Used to select Ethereum request endpoints
 */
interface NetworkService {
    //return price
    @GET("api?module=stats&action=ethprice&apikey={apiToken}")
    fun getLastPrice(@Path("result") token: String): Observable<EtherPrice>

    //return supply
    @GET("api?module=stats&action=ethsupply&apikey={apiToken}")
    fun getTotalSupply(@Path("result") token: String): Observable<EtherPrice>
}