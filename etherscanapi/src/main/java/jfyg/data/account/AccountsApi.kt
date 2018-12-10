package jfyg.data.account

import jfyg.network.queries.ApiQuery
import jfyg.network.response.*
import jfyg.utils.*
import retrofit2.Response

/**
 * https://etherscan.io/apis#accounts
 */
class AccountsApi : AccountsContract {

    private val query = ApiQuery()

    /**
     * Get Ether Balance for a single Address
     */
    override suspend fun getBalance(address: String):
            Response<AccountBalanceResponse> = query.accountBalance(
            ACCOUNT,
            BALANCE,
            address,
            LATEST)

    /**
     * Get Ether Balance for multiple Addresses in a single call
     */
    override suspend fun getMultiBalance(addresses: List<String>):
            Response<AccountMultiBalanceResponse> = query.accountMultiBalance(
            ACCOUNT,
            BALANCE_MULTI,
            retrieveList(addresses),
            LATEST)

    /**
     * Get list of blocks mined by address
     */
    override suspend fun getBlocks(address: String):
            Response<AccountBlockResponse> = query.accountBlock(
            ACCOUNT,
            GET_MINED_BLOCKS,
            address,
            BLOCKS)

    /**
     * Get a list of 'Normal' Transactions By Address
     */
    override suspend fun getTransactions(address: String):
            Response<AccountTxResponse> = query.accountTxs(
            ACCOUNT,
            TX_LIST,
            address,
            START_BLOCK,
            END_BLOCK,
            ASC)

    /**
     * [BETA] Get a list of "ERC20 - Token Transfer Events" by Address
     */
    override suspend fun getERC20Tokens(address: String):
            Response<ERC20Response> = query.accountERC20Txs(
            ACCOUNT,
            TOKEN_TX,
            address,
            START_BLOCK,
            END_BLOCK,
            ASC)


    /**
     * [BETA] Get a list of 'Internal' Transactions by Address
     */
    override suspend fun getInternalTransactions(address: String):
            Response<AccountInternalTxResponse> = query.accountInternalTxs(
            ACCOUNT,
            TX_LIST_INTERNAL,
            address,
            START_BLOCK,
            END_BLOCK,
            ASC)

    /**
     * Return network status
     */
    override suspend fun getNetworkStatus(): Response<AccountBalanceResponse> = query.accountBalance(
            ACCOUNT,
            BALANCE,
            GENERIC_PUBLIC_ADDRESS,
            LATEST)

    /**
     * Return network message
     */
    override suspend fun getNetworkMessage(): Response<AccountBalanceResponse> = query.accountBalance(
            ACCOUNT,
            BALANCE,
            GENERIC_PUBLIC_ADDRESS,
            LATEST)

}