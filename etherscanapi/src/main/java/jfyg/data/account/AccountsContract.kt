package jfyg.data.account

import jfyg.network.response.*
import retrofit2.Response

/**
 * https://etherscan.io/apis#accounts
 */
internal interface AccountsContract {

    /**
     * Get Ether Balance for a single Address
     */
    suspend fun getBalance(address: String): Response<AccountBalanceResponse>

    /**
     * Get Ether Balance for multiple Addresses in a single call
     */
    suspend fun getMultiBalance(addresses: List<String>): Response<AccountMultiBalanceResponse>

    /**
     * Get list of blocks mined by address
     */
    suspend fun getBlocks(address: String): Response<AccountBlockResponse>

    /**
     * Get a list of 'Normal' Transactions By Address
     */
    suspend fun getTransactions(address: String): Response<AccountTxResponse>

    /**
     * [BETA] Get a list of "ERC20 - Token Transfer Events" by Address
     */
    suspend fun getERC20Tokens(address: String): Response<ERC20Response>

    /**
     * [BETA] Get a list of 'Internal' Transactions by Address
     */
    suspend fun getInternalTransactions(address: String): Response<AccountInternalTxResponse>

    /**
     * Return network status
     */
    suspend fun getNetworkStatus(): Response<AccountBalanceResponse>

    /**
     * Return network message
     */
    suspend fun getNetworkMessage(): Response<AccountBalanceResponse>
}