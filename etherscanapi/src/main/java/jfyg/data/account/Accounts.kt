package jfyg.data.account

import io.reactivex.Single
import jfyg.data.Balance
import jfyg.data.BlockAccount
import jfyg.data.ERC20Token
import jfyg.data.Tx
import jfyg.data.TxsInternal
import jfyg.network.queries.ApiQuery
import jfyg.utils.Const
import jfyg.utils.QueryUtils

/**
 * https://etherscan.io/apis#accounts
 */
class Accounts : AccountsContract {

    private val query = ApiQuery()
    private val genericNetworkQuery = query.accountBalance(
            Const.ACCOUNT,
            Const.BALANCE,
            Const.GENERIC_PUBLIC_ADDRESS,
            Const.LATEST)

    /**
     * Get Ether Balance for a single Address
     */
    override fun getBalance(address: String?):
            Single<Double> = query.accountBalance(
            Const.ACCOUNT,
            Const.BALANCE,
            address,
            Const.LATEST).map { it.result?.toDouble() }

    /**
     * Get Ether Balance for multiple Addresses in a single call
     */
    override fun getMultiBalance(addresses: List<String>?):
            Single<List<Balance>> = query.accountMultiBalance(
            Const.ACCOUNT,
            Const.BALANCE_MULTI,
            QueryUtils.retrieveList(addresses),
            Const.LATEST).map { it.result }

    /**
     * Get list of blocks mined by address
     */
    override fun getBlocks(address: String?):
            Single<List<BlockAccount>> = query.accountBlock(
            Const.ACCOUNT,
            Const.GET_MINED_BLOCKS,
            address,
            Const.BLOCKS).map { it.result }

    /**
     * Get a list of 'Normal' Transactions By Address
     */
    override fun getTransactions(address: String?):
            Single<List<Tx>> = query.accountTxs(Const.ACCOUNT,
            Const.TX_LIST,
            address,
            Const.START_BLOCK,
            Const.END_BLOCK,
            Const.ASC).map { it.result }

    /**
     * [BETA] Get a list of "ERC20 - Token Transfer Events" by Address
     */
    override fun getERC20Tokens(address: String?):
            Single<List<ERC20Token>> = query.accountERC20Txs(
            Const.ACCOUNT,
            Const.TOKEN_TX,
            address,
            Const.START_BLOCK,
            Const.END_BLOCK,
            Const.ASC).map { it.result }


    /**
     * [BETA] Get a list of 'Internal' Transactions by Address
     */
    override fun getInternalTransactions(address: String?):
            Single<List<TxsInternal>> = query.accountInternalTxs(
            Const.ACCOUNT,
            Const.TX_LIST_INTERNAL,
            address,
            Const.START_BLOCK,
            Const.END_BLOCK,
            Const.ASC).map { it.result }

    /**
     * Return network status
     */
    override fun getNetworkStatus(): Single<String> = genericNetworkQuery.map { it.status }

    /**
     * Return network message
     */
    override fun getNetworkMessage(): Single<String> = genericNetworkQuery.map { it.message }

}