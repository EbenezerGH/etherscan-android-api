package jfyg.queries

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import jfyg.ApiKey
import jfyg.network.RestClient
import jfyg.response.account.AccountBalanceResponse
import jfyg.response.account.AccountBlockResponse
import jfyg.response.account.AccountMultiBalanceResponse
import jfyg.response.account.AccountTransactionResponse
import jfyg.response.stat.StatPriceResponse
import jfyg.response.stat.StatSupplyResponse

/**
 * A mediator between the responses and errors that come from every query
 */
class QueryMediator : AccountQueries, StatQueries { //todo #36
    private val TAG = javaClass.name

    private var statPriceInfo = StatPriceResponse()
    private var statSupplyInfo = StatSupplyResponse()
    private var accountBalanceInfo = AccountBalanceResponse()
    private var accountMultiBalanceInfo = AccountMultiBalanceResponse()
    private var accountBlockInfo = AccountBlockResponse()
    private var accountTransactionInfo = AccountTransactionResponse()


    override fun accountBalance(module: String?, action: String?, address: String?, tag: String?): Disposable? =
            RestClient().getQuery().getAccountBalance(module, action, address, tag,
                    ApiKey.takeOff.callApiKey())

                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponse, this::handleError)


    override fun accountMultiBalance(module: String?, action: String?, address: String?, tag: String?): Disposable? =
            RestClient().getQuery().getAccountMultiBalance(module, action, address, tag,
                    ApiKey.takeOff.callApiKey())

                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponse, this::handleError)


    override fun accountBlock(module: String?, action: String?, address: String?, blocktype: String?): Disposable? =
            RestClient().getQuery().getAccountBlock(module, action, address, blocktype, ApiKey.takeOff.callApiKey())

                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponse, this::handleError)


    override fun accountTransactions(module: String?, action: String?, address: String?, startblock: String?,
                                     endblock: String?, sort: String?): Disposable? =
            RestClient().getQuery().getAccountTransactions(module, action, address, startblock, endblock, sort,
                    ApiKey.takeOff.callApiKey())

                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponse, this::handleError)


    override fun statPrice(module: String, action: String): Disposable? =

            RestClient().getQuery()
                    .getStat(module, action, ApiKey.takeOff.callApiKey())

                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponse, this::handleError)


    override fun statSupply(module: String, action: String): Disposable? =

            RestClient().getQuery()
                    .getStatSupply(module, action, ApiKey.takeOff.callApiKey())

                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(this::handleResponse, this::handleError)


    override fun handleResponse(response: AccountBalanceResponse) {
        accountBalanceInfo = response
    }

    override fun handleResponse(response: AccountBlockResponse) {
        accountBlockInfo = response
    }

    override fun handleResponse(response: AccountTransactionResponse) {
        accountTransactionInfo = response
    }

    override fun handleResponse(response: StatPriceResponse) {
        statPriceInfo = response
    }

    override fun handleResponse(response: StatSupplyResponse) {
        statSupplyInfo = response
    }

    override fun handleResponse(response: AccountMultiBalanceResponse) {
        accountMultiBalanceInfo = response
    }

    private fun handleError(error: Throwable) {
        Log.d(TAG, "The error ${error.message}")
    }

    fun fetchStatPrice(): StatPriceResponse? = statPriceInfo
    fun fetchStatSupply(): StatSupplyResponse? = statSupplyInfo
    fun fetchAccountBalance(): AccountBalanceResponse? = accountBalanceInfo
    fun fetchAccountMultiBalance(): AccountMultiBalanceResponse? = accountMultiBalanceInfo
    fun fetchAccountBlock(): AccountBlockResponse? = accountBlockInfo
    fun fetchAccountTransaction(): AccountTransactionResponse? = accountTransactionInfo

}