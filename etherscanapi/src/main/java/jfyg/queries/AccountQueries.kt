package jfyg.queries

import io.reactivex.Single
import jfyg.response.account.AccountBalanceResponse
import jfyg.response.account.AccountBlockResponse
import jfyg.response.account.AccountInternalTransactionResponse
import jfyg.response.account.AccountMultiBalanceResponse
import jfyg.response.account.AccountTransactionResponse

internal interface AccountQueries {

    /**
     * Get Ether balance for a single address
     */
    fun accountBalance(module: String?,
                       action: String?,
                       address: String?,
                       tag: String?): Single<AccountBalanceResponse>?

    /**
     * Get Ether Balance for multiple Addresses in a single call
     */
    fun accountMultiBalance(module: String?,
                            action: String?,
                            address: String?,
                            tag: String?): Single<AccountMultiBalanceResponse>?

    /**
     * Get list of blocks mined by address
     */
    fun accountBlock(module: String?,
                     action: String?,
                     address: String?,
                     blocktype: String?): Single<AccountBlockResponse>?

    /**
     * Get a list of 'Normal' transactions by address
     */
    fun accountTransactions(module: String?,
                            action: String?,
                            address: String?,
                            startblock: String?,
                            endblock: String?,
                            sort: String?): Single<AccountTransactionResponse>?

    /**
     * Get a list of 'Internal' transactions by address
     */
    fun accountInternalTransactions(module: String?,
                                    action: String?,
                                    address: String?,
                                    startblock: String?,
                                    endblock: String?,
                                    sort: String?): Single<AccountInternalTransactionResponse>?

}