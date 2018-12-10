package jfyg.network

import jfyg.network.response.AccountBalanceResponse
import jfyg.network.response.AccountBlockResponse
import jfyg.network.response.ERC20Response
import jfyg.network.response.AccountInternalTxResponse
import jfyg.network.response.AccountMultiBalanceResponse
import jfyg.network.response.AccountTxResponse
import jfyg.network.response.BlockResponse
import jfyg.network.response.ContractResponse
import jfyg.network.response.StatPriceResponse
import jfyg.network.response.StatSupplyResponse
import jfyg.network.response.TxContractExecutionResponse
import jfyg.network.response.TxContractReceiptResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Etherscan request service
 *
 * Note: The Api allows for null parameters to be passed so I allow for every query to be nullable
 */
internal interface NetworkService {

    @GET("api")
    fun getStat(@Query("module") module: String?,
                @Query("action") action: String?,
                @Query("apikey") apikey: String?): Deferred<Response<StatPriceResponse>>

    @GET("api")
    fun getStatSupply(@Query("module") module: String?,
                      @Query("action") action: String?,
                      @Query("apikey") apikey: String?): Deferred<Response<StatSupplyResponse>>

    @GET("api")
    fun getAccountBalance(@Query("module") module: String?,
                          @Query("action") action: String?,
                          @Query("address") address: String?,
                          @Query("tag") tag: String?,
                          @Query("apikey") apikey: String?): Deferred<Response<AccountBalanceResponse>>

    @GET("api")
    fun getAccountMultiBalance(@Query("module") module: String?,
                               @Query("action") action: String?,
                               @Query("address") address: String?,
                               @Query("tag") tag: String?,
                               @Query("apikey") apikey: String?): Deferred<Response<AccountMultiBalanceResponse>>

    @GET("api")
    fun getAccountBlock(@Query("module") module: String?,
                        @Query("action") action: String?,
                        @Query("address") address: String?,
                        @Query("blocktype") blocktype: String?,
                        @Query("apikey") apikey: String?): Deferred<Response<AccountBlockResponse>>

    @GET("api")
    fun getAccountTransactions(@Query("module") module: String?,
                               @Query("action") action: String?,
                               @Query("address") address: String?,
                               @Query("startblock") startblock: String?,
                               @Query("endblock") endblock: String?,
                               @Query("sort") sort: String?,
                               @Query("apikey") apikey: String?): Deferred<Response<AccountTxResponse>>

    @GET("api")
    fun getAccountERC20Transactions(@Query("module") module: String?,
                                    @Query("action") action: String?,
                                    @Query("address") address: String?,
                                    @Query("startblock") startblock: String?,
                                    @Query("endblock") endblock: String?,
                                    @Query("sort") sort: String?,
                                    @Query("apikey") apikey: String?): Deferred<Response<ERC20Response>>

    @GET("api")
    fun getAccountInternalTransactions(@Query("module") module: String?,
                                       @Query("action") action: String?,
                                       @Query("address") address: String?,
                                       @Query("startblock") startblock: String?,
                                       @Query("endblock") endblock: String?,
                                       @Query("sort") sort: String?,
                                       @Query("apikey") apikey: String?): Deferred<Response<AccountInternalTxResponse>>

    @GET("api")
    fun getSmartContract(@Query("module") module: String?,
                         @Query("action") action: String?,
                         @Query("address") address: String?,
                         @Query("apikey") apikey: String?): Deferred<Response<ContractResponse>>

    @GET("api")
    fun getContractTransactionExecution(@Query("module") module: String?,
                                        @Query("action") action: String?,
                                        @Query("txhash") address: String?,
                                        @Query("apikey") apikey: String?): Deferred<Response<TxContractExecutionResponse>>

    @GET("api")
    fun getContractTransactionReceipt(@Query("module") module: String?,
                                      @Query("action") action: String?,
                                      @Query("txhash") address: String?,
                                      @Query("apikey") apikey: String?): Deferred<Response<TxContractReceiptResponse>>

    @GET("api")
    fun getBlocksMined(@Query("module") module: String?,
                       @Query("action") action: String?,
                       @Query("blockno") address: String?,
                       @Query("apikey") apikey: String?): Deferred<Response<BlockResponse>>

}