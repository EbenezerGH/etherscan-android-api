package jfyg.network

import io.reactivex.Single
import jfyg.response.MainResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Etherscan request endpoints
 */
interface NetworkService {

    @GET("api")
    fun getEtherStats(@Query("module") module: String,
                      @Query("action") action: String,
                      @Query("apikey") apikey: String?): Single<MainResponse>
}