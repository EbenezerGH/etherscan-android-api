package jfyg.queries

import io.reactivex.disposables.Disposable
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
                       tag: String?): Disposable?

    /**
     * Get Ether Balance for multiple Addresses in a single call
     */
    fun accountMultiBalance(module: String?,
                            action: String?,
                            address: String?,
                            tag: String?): Disposable?

    /**
     * Get list of blocks mined by address
     */
    fun accountBlock(module: String?,
                     action: String?,
                     address: String?,
                     blocktype: String?): Disposable?

    /**
     * Get a list of 'Normal' transactions by address
     */
    fun accountTransactions(module: String?,
                            action: String?,
                            address: String?,
                            startblock: String?,
                            endblock: String?,
                            sort: String?): Disposable?

    /**
     * Get a list of 'Internal' transactions by address
     */
    fun accountInternalTransactions(module: String?,
                                    action: String?,
                                    address: String?,
                                    startblock: String?,
                                    endblock: String?,
                                    sort: String?): Disposable?

    fun handleResponse(response: AccountBalanceResponse)

    fun handleResponse(response: AccountMultiBalanceResponse)

    fun handleResponse(response: AccountBlockResponse)

    fun handleResponse(response: AccountTransactionResponse)

    fun handleResponse(response: AccountInternalTransactionResponse)

}