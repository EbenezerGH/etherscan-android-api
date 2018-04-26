package jfyg.data.account

import io.reactivex.Single
import jfyg.data.Balances
import jfyg.data.Blocks
import jfyg.data.ERC20Token
import jfyg.data.Txs
import jfyg.data.TxsInternal
import jfyg.network.queries.ApiQuery
import jfyg.utils.Const
import jfyg.utils.QueryUtils

/**
 * https://etherscan.io/apis#accounts
 */
class Account : AccountContract {

    private val query = ApiQuery()
    private val genericNetworkQuery = query.accountBalance("account",
            "balance",
            Const.GENERIC_PUBLIC_ADDRESS,
            "latest")

    /**
     * Return account balance
     */
    override fun getBalance(address: String?): Single<Double> =
            query.accountBalance("account",
                    "balance",
                    address,
                    "latest").map { it.result?.toDouble() }

    /**
     * Return balances of multiple accounts separated by commas
     */
    override fun getMultiBalance(addresses: ArrayList<String>?): Single<ArrayList<Balances>> =
            query.accountMultiBalance("account",
                    "balancemulti",
                    QueryUtils.retrieveList(addresses),
                    "latest").map { it.result }

    /**
     * Get list of blocks mined by address
     */
    override fun getBlocks(address: String?): Single<ArrayList<Blocks>> =
            query.accountBlock("account",
                    "getminedblocks",
                    address,
                    "blocks").map { it.result }

    /**
     * Get a list of 'Normal' Transactions By Address
     */
    override fun getTransactions(address: String?): Single<ArrayList<Txs>> =
            query.accountTxs("account",
                    "txlist",
                    address,
                    "0",
                    "99999999",
                    "asc").map { it.result }

    /**
     * [BETA] Get a list of "ERC20 - Token Transfer Events" by Address
     */
    override fun getERC20Tokens(address: String?): Single<ArrayList<ERC20Token>> =
            query.accountERC20Txs("account",
                    "tokentx",
                    address,
                    "0",
                    "999999999",
                    "asc").map { it.result }


    /**
     * [BETA] Get a list of 'Internal' Transactions by Address
     */
    override fun getInternalTransactions(address: String?): Single<ArrayList<TxsInternal>> =
            query.accountInternalTxs("account",
                    "txlistinternal",
                    address,
                    "0",
                    "99999999",
                    "asc").map { it.result }

    /**
     * Return network status
     */
    override fun getNetworkStatus(): Single<String> = genericNetworkQuery.map { it.status }

    /**
     * Return network message
     */
    override fun getNetworkMessage(): Single<String> = genericNetworkQuery.map { it.message }

}