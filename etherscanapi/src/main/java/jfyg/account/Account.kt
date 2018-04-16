package jfyg.account

import io.reactivex.Single
import jfyg.model.Balances
import jfyg.model.Blocks
import jfyg.model.Transactions
import jfyg.model.TransactionsInternal
import jfyg.queries.QueryMediator
import jfyg.utils.QueryUtils

class Account : AccountContract {

    private val query = QueryMediator()
    private val genericNetworkQuery = query.accountBalance("account",
            "balance",
            "0x82e4499D4b2A669831a3881d61BB24f7b620c61a",
            "latest")

    private val queryUtil = QueryUtils()

    override fun getBalance(account: String?): Single<Double> =
            query.accountBalance("account",
                    "balance",
                    account,
                    "latest").map { it.result?.toDouble() }

    override fun getMultiBalance(accounts: ArrayList<String>?): Single<ArrayList<Balances>> =
            query.accountMultiBalance("account",
                    "balancemulti",
                    queryUtil.retrieveAccounts(accounts),
                    "latest").map { it.result }

    override fun getBlocks(account: String?): Single<ArrayList<Blocks>> =
            query.accountBlock("account",
                    "getminedblocks",
                    account,
                    "blocks").map { it.result }

    override fun getTransactions(account: String?): Single<ArrayList<Transactions>> =
            query.accountTransactions("account",
                    "txlist",
                    account,
                    "0",
                    "99999999",
                    "asc").map { it.result }

    override fun getInternalTransactions(account: String?): Single<ArrayList<TransactionsInternal>> =
            query.accountInternalTransactions("account",
                    "txlistinternal",
                    account,
                    "0",
                    "99999999",
                    "asc").map { it.result }

    override fun getNetworkStatus(): Single<String> = genericNetworkQuery.map { it.status }

    override fun getNetworkMessage(): Single<String> = genericNetworkQuery.map { it.message }

}