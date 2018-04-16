package jfyg.queries

import io.reactivex.Single
import jfyg.ApiKey
import jfyg.network.RestClient
import jfyg.response.account.AccountBalanceResponse
import jfyg.response.account.AccountBlockResponse
import jfyg.response.account.AccountInternalTransactionResponse
import jfyg.response.account.AccountMultiBalanceResponse
import jfyg.response.account.AccountTransactionResponse
import jfyg.response.stat.StatPriceResponse
import jfyg.response.stat.StatSupplyResponse

/**
 * A mediator between the responses and errors that come from every query
 */
internal class QueryMediator : AccountQueries, StatQueries {

    override fun accountBalance(module: String?,
                                action: String?,
                                address: String?,
                                tag: String?): Single<AccountBalanceResponse>? =
            RestClient().getQuery().getAccountBalance(module, action, address, tag, ApiKey.takeOff.callApiKey())

    override fun accountMultiBalance(module: String?,
                                     action: String?,
                                     address: String?,
                                     tag: String?): Single<AccountMultiBalanceResponse>? =
            RestClient().getQuery().getAccountMultiBalance(module, action, address, tag, ApiKey.takeOff.callApiKey())

    override fun accountBlock(module: String?,
                              action: String?,
                              address: String?,
                              blocktype: String?): Single<AccountBlockResponse>? =
            RestClient().getQuery().getAccountBlock(module, action, address, blocktype, ApiKey.takeOff.callApiKey())

    override fun accountTransactions(module: String?,
                                     action: String?,
                                     address: String?,
                                     startblock: String?,
                                     endblock: String?,
                                     sort: String?): Single<AccountTransactionResponse>? =
            RestClient().getQuery().getAccountTransactions(module, action, address, startblock, endblock, sort, ApiKey.takeOff.callApiKey())

    override fun accountInternalTransactions(module: String?,
                                             action: String?,
                                             address: String?,
                                             startblock: String?,
                                             endblock: String?,
                                             sort: String?): Single<AccountInternalTransactionResponse>? =
            RestClient().getQuery().getAccountInternalTransactions(module, action, address, startblock, endblock, sort, ApiKey.takeOff.callApiKey())

    override fun statPrice(module: String,
                           action: String): Single<StatPriceResponse>? =
            RestClient().getQuery().getStat(module, action, ApiKey.takeOff.callApiKey())


    override fun statSupply(module: String,
                            action: String): Single<StatSupplyResponse>? =
            RestClient().getQuery().getStatSupply(module, action, ApiKey.takeOff.callApiKey())

}