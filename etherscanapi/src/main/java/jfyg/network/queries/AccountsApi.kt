package jfyg.network.queries

import jfyg.network.response.AccountBalanceResponse
import jfyg.network.response.AccountBlockResponse
import jfyg.network.response.ERC20Response
import jfyg.network.response.AccountInternalTxResponse
import jfyg.network.response.AccountMultiBalanceResponse
import jfyg.network.response.AccountTxResponse
import retrofit2.Response

/**
 * https://etherscan.io/apis#accounts
 */
internal interface AccountsApi {

    /**
     * Get Ether Balance for a single Address
     */
    suspend fun accountBalance(module: String,
                       action: String,
                       address: String,
                       tag: String): Response<AccountBalanceResponse>

    /**
     * Get Ether Balance for multiple Addresses in a single call
     */
    suspend fun accountMultiBalance(module: String,
                            action: String,
                            address: String,
                            tag: String?): Response<AccountMultiBalanceResponse>

    /**
     * Get list of blocks mined by address
     */
    suspend fun accountBlock(module: String,
                     action: String,
                     address: String,
                     blocktype: String): Response<AccountBlockResponse>

    /**
     * Get a list of 'Normal' Transactions By Address
     */
    suspend fun accountTxs(module: String,
                   action: String,
                   address: String,
                   startblock: String,
                   endblock: String,
                   sort: String): Response<AccountTxResponse>

    /**
     * [BETA] Get a list of "ERC20 - Token Transfer Events" by Address
     */
    suspend fun accountERC20Txs(module: String,
                        action: String,
                        address: String,
                        startblock: String,
                        endblock: String,
                        sort: String): Response<ERC20Response>

    /**
     * [BETA] Get a list of 'Internal' Transactions by Address
     */
    suspend fun accountInternalTxs(module: String,
                           action: String,
                           address: String,
                           startblock: String,
                           endblock: String,
                           sort: String): Response<AccountInternalTxResponse>

}