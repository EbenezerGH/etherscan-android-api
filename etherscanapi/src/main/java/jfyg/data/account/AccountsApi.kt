package jfyg.data.account

import io.reactivex.Single
import jfyg.data.Balance
import jfyg.data.BlockAccount
import jfyg.data.ERC20Token
import jfyg.data.Tx
import jfyg.data.TxsInternal
import jfyg.network.queries.ApiQuery
import jfyg.utils.*

/**
 * https://etherscan.io/apis#accounts
 */
class AccountsApi : AccountsContract {

    private val query = ApiQuery()
    private val genericNetworkQuery = query.accountBalance(
            ACCOUNT,
            BALANCE,
            GENERIC_PUBLIC_ADDRESS,
            LATEST)

    /**
     * Get Ether Balance for a single Address
     */
    override fun getBalance(address: String):
            Single<Double> = query.accountBalance(
            ACCOUNT,
            BALANCE,
            address,
            LATEST).map { it.result?.toDouble() }

    /**
     * Get Ether Balance for multiple Addresses in a single call
     */
    override fun getMultiBalance(addresses: List<String>):
            Single<List<Balance>> = query.accountMultiBalance(
            ACCOUNT,
            BALANCE_MULTI,
            retrieveList(addresses),
            LATEST).map { it.result }

    /**
     * Get list of blocks mined by address
     */
    override fun getBlocks(address: String):
            Single<List<BlockAccount>> = query.accountBlock(
            ACCOUNT,
            GET_MINED_BLOCKS,
            address,
            BLOCKS).map { it.result }

    /**
     * Get a list of 'Normal' Transactions By Address
     */
    override fun getTransactions(address: String):
            Single<List<Tx>> = query.accountTxs(
            ACCOUNT,
            TX_LIST,
            address,
            START_BLOCK,
            END_BLOCK,
            ASC).map { it.result }

    /**
     * [BETA] Get a list of "ERC20 - Token Transfer Events" by Address
     */
    override fun getERC20Tokens(address: String):
            Single<List<ERC20Token>> = query.accountERC20Txs(
            ACCOUNT,
            TOKEN_TX,
            address,
            START_BLOCK,
            END_BLOCK,
            ASC).map { it.result }


    /**
     * [BETA] Get a list of 'Internal' Transactions by Address
     */
    override fun getInternalTransactions(address: String):
            Single<List<TxsInternal>> = query.accountInternalTxs(
            ACCOUNT,
            TX_LIST_INTERNAL,
            address,
            START_BLOCK,
            END_BLOCK,
            ASC).map { it.result }

    /**
     * Return network status
     */
    override fun getNetworkStatus(): Single<String> = genericNetworkQuery.map { it.status }

    /**
     * Return network message
     */
    override fun getNetworkMessage(): Single<String> = genericNetworkQuery.map { it.message }

}