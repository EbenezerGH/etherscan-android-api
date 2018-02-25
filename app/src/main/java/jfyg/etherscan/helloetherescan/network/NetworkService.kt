package jfyg.etherscan.helloetherescan.network

import io.reactivex.Observable
import jfyg.etherscan.helloetherescan.network.responses.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Etherscan request endpoints
 */
interface NetworkService {

    @GET("api")
    fun getEtherStats(@Query("module") module: String,
                      @Query("action") action: String,
                      @Query("apikey") apikey: String): Observable<BaseResponse>
}