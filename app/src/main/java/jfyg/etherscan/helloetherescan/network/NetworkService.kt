package jfyg.etherscan.helloetherescan.network

import io.reactivex.Observable
import jfyg.etherscan.helloetherescan.model.EtherPrice
import jfyg.etherscan.helloetherescan.model.EtherSupply
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Used to select Etherscan request endpoints
 */
interface NetworkService {
    //todo: https://github.com/EbenezerGH/hello_etherscan/issues/1
    //return price
    @GET("api")
    fun getLastPrice(@Query("module=stats&action=ethprice&apikey") token: String): Observable<EtherPrice>

    //return supply
    @GET("api")
    fun getTotalSupply(@Query("module=stats&action=ethsupply&apikey") token: String): Observable<EtherSupply>
}