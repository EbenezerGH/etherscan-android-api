package jfyg.account

import io.reactivex.Single
import jfyg.model.Balances
import jfyg.model.Blocks
import jfyg.model.Txs
import jfyg.model.TxsInternal
import jfyg.queries.QueryMediator
import jfyg.utils.QueryUtils

/**
 * https://etherscan.io/apis#accounts
 */
class Account : AccountContract {

    private val query = QueryMediator()
    private val genericNetworkQuery = query.accountBalance("account",
            "balance",
            "0x82e4499D4b2A669831a3881d61BB24f7b620c61a",
            "latest")

    private val queryUtil = QueryUtils()

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
                    queryUtil.retrieveList(addresses),
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
            query.accountTransactions("account",
                    "txlist",
                    address,
                    "0",
                    "99999999",
                    "asc").map { it.result }

    /**
     * Get a list of 'Internal' Transactions by Address
     */
    override fun getInternalTransactions(address: String?): Single<ArrayList<TxsInternal>> =
            query.accountInternalTransactions("account",
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