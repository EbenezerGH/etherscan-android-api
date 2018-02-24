package jfyg.etherscan.helloetherescan.network

import io.reactivex.Observable
import jfyg.etherscan.helloetherescan.model.EtherPrice
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Used to select Ethereum request endpoints
 */
interface NetworkService {
    @GET("stats&action=ethprice&apikey={apiToken}")
    fun getLastPrice(@Path("result") price: Int): Observable<EtherPrice>

    @GET("stats&action=ethsupply&apikey={apiToken}")
    fun getTotalSupply(@Path("result") supply: Int): Observable<EtherPrice>
}