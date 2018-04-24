package jfyg.network.queries

import io.reactivex.Single
import jfyg.network.response.account.AccountBalanceResponse
import jfyg.network.response.account.AccountBlockResponse
import jfyg.network.response.account.AccountInternalTxResponse
import jfyg.network.response.account.AccountMultiBalanceResponse
import jfyg.network.response.account.AccountTxResponse

internal interface AccountApi {

    /**
     * Get ether balance for a single address
     */
    fun accountBalance(module: String?,
                       action: String?,
                       address: String?,
                       tag: String?): Single<AccountBalanceResponse>

    /**
     * Get ether Balance for multiple addresses in a single call
     */
    fun accountMultiBalance(module: String?,
                            action: String?,
                            address: String?,
                            tag: String?): Single<AccountMultiBalanceResponse>

    /**
     * Get list of blocks mined by address
     */
    fun accountBlock(module: String?,
                     action: String?,
                     address: String?,
                     blocktype: String?): Single<AccountBlockResponse>

    /**
     * Get a list of 'Normal' transactions by address
     */
    fun accountTransactions(module: String?,
                            action: String?,
                            address: String?,
                            startblock: String?,
                            endblock: String?,
                            sort: String?): Single<AccountTxResponse>

    /**
     * Get a list of 'Internal' transactions by address
     */
    fun accountInternalTransactions(module: String?,
                                    action: String?,
                                    address: String?,
                                    startblock: String?,
                                    endblock: String?,
                                    sort: String?): Single<AccountInternalTxResponse>

}