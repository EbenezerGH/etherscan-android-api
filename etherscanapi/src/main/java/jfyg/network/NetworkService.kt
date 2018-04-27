package jfyg.network

import io.reactivex.Single
import jfyg.network.response.account.AccountBalanceResponse
import jfyg.network.response.account.AccountBlockResponse
import jfyg.network.response.account.ERC20Response
import jfyg.network.response.account.AccountInternalTxResponse
import jfyg.network.response.account.AccountMultiBalanceResponse
import jfyg.network.response.account.AccountTxResponse
import jfyg.network.response.block.BlockResponse
import jfyg.network.response.contract.ContractResponse
import jfyg.network.response.stat.StatPriceResponse
import jfyg.network.response.stat.StatSupplyResponse
import jfyg.network.response.transaction.TxContractExecutionResponse
import jfyg.network.response.transaction.TxContractReceiptResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Etherscan request service
 */
internal interface NetworkService {

    @GET("api")
    fun getStat(@Query("module") module: String?,
                @Query("action") action: String?,
                @Query("apikey") apikey: String?): Single<StatPriceResponse>

    @GET("api")
    fun getStatSupply(@Query("module") module: String?,
                      @Query("action") action: String?,
                      @Query("apikey") apikey: String?): Single<StatSupplyResponse>

    @GET("api")
    fun getAccountBalance(@Query("module") module: String?,
                          @Query("action") action: String?,
                          @Query("address") address: String?,
                          @Query("tag") tag: String?,
                          @Query("apikey") apikey: String?): Single<AccountBalanceResponse>

    @GET("api")
    fun getAccountMultiBalance(@Query("module") module: String?,
                               @Query("action") action: String?,
                               @Query("address") address: String?,
                               @Query("tag") tag: String?,
                               @Query("apikey") apikey: String?): Single<AccountMultiBalanceResponse>

    @GET("api")
    fun getAccountBlock(@Query("module") module: String?,
                        @Query("action") action: String?,
                        @Query("address") address: String?,
                        @Query("blocktype") blocktype: String?,
                        @Query("apikey") apikey: String?): Single<AccountBlockResponse>

    @GET("api")
    fun getAccountTransactions(@Query("module") module: String?,
                               @Query("action") action: String?,
                               @Query("address") address: String?,
                               @Query("startblock") startblock: String?,
                               @Query("endblock") endblock: String?,
                               @Query("sort") sort: String?,
                               @Query("apikey") apikey: String?): Single<AccountTxResponse>

    @GET("api")
    fun getAccountERC20Transactions(@Query("module") module: String?,
                                    @Query("action") action: String?,
                                    @Query("address") address: String?,
                                    @Query("startblock") startblock: String?,
                                    @Query("endblock") endblock: String?,
                                    @Query("sort") sort: String?,
                                    @Query("apikey") apikey: String?): Single<ERC20Response>

    @GET("api")
    fun getAccountInternalTransactions(@Query("module") module: String?,
                                       @Query("action") action: String?,
                                       @Query("address") address: String?,
                                       @Query("startblock") startblock: String?,
                                       @Query("endblock") endblock: String?,
                                       @Query("sort") sort: String?,
                                       @Query("apikey") apikey: String?): Single<AccountInternalTxResponse>

    @GET("api")
    fun getSmartContract(@Query("module") module: String?,
                         @Query("action") action: String?,
                         @Query("address") address: String?,
                         @Query("apikey") apikey: String?): Single<ContractResponse>

    @GET("api")
    fun getContractTransactionExecution(@Query("module") module: String?,
                                        @Query("action") action: String?,
                                        @Query("txhash") address: String?,
                                        @Query("apikey") apikey: String?): Single<TxContractExecutionResponse>

    @GET("api")
    fun getContractTransactionReceipt(@Query("module") module: String?,
                                      @Query("action") action: String?,
                                      @Query("txhash") address: String?,
                                      @Query("apikey") apikey: String?): Single<TxContractReceiptResponse>

    @GET("api")
    fun getBlocksMined(@Query("module") module: String?,
                       @Query("action") action: String?,
                       @Query("blockno") address: String?,
                       @Query("apikey") apikey: String?): Single<BlockResponse>

}