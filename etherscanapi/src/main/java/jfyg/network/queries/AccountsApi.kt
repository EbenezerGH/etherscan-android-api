package jfyg.network.queries

import io.reactivex.Single
import jfyg.network.response.AccountBalanceResponse
import jfyg.network.response.AccountBlockResponse
import jfyg.network.response.ERC20Response
import jfyg.network.response.AccountInternalTxResponse
import jfyg.network.response.AccountMultiBalanceResponse
import jfyg.network.response.AccountTxResponse

/**
 * https://etherscan.io/apis#accounts
 */
internal interface AccountsApi {

    /**
     * Get Ether Balance for a single Address
     */
    fun accountBalance(module: String,
                       action: String,
                       address: String,
                       tag: String): Single<AccountBalanceResponse>

    /**
     * Get Ether Balance for multiple Addresses in a single call
     */
    fun accountMultiBalance(module: String,
                            action: String,
                            address: String,
                            tag: String?): Single<AccountMultiBalanceResponse>

    /**
     * Get list of blocks mined by address
     */
    fun accountBlock(module: String,
                     action: String,
                     address: String,
                     blocktype: String): Single<AccountBlockResponse>

    /**
     * Get a list of 'Normal' Transactions By Address
     */
    fun accountTxs(module: String,
                   action: String,
                   address: String,
                   startblock: String,
                   endblock: String,
                   sort: String): Single<AccountTxResponse>

    /**
     * [BETA] Get a list of "ERC20 - Token Transfer Events" by Address
     */
    fun accountERC20Txs(module: String,
                        action: String,
                        address: String,
                        startblock: String,
                        endblock: String,
                        sort: String): Single<ERC20Response>

    /**
     * [BETA] Get a list of 'Internal' Transactions by Address
     */
    fun accountInternalTxs(module: String,
                           action: String,
                           address: String,
                           startblock: String,
                           endblock: String,
                           sort: String): Single<AccountInternalTxResponse>

}