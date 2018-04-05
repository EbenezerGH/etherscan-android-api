package jfyg.account

import jfyg.model.Balances
import jfyg.model.Blocks
import jfyg.model.Transactions
import jfyg.queries.QueryMediator

class Account : AccountContract {

    private val query = QueryMediator()
    private val genericNetworkQuery = query.accountBalance("account", "balance",
            "0x82e4499D4b2A669831a3881d61BB24f7b620c61a", "latest")

    override fun getBalance(account: String?): Double? = let {
        query.accountBalance("account", "balance",
                account, "latest").let { query.fetchAccountBalance()?.result?.toDouble() }
    }

    override fun getMultiBalance(accounts: List<String>?): ArrayList<Balances>? = let { //todo #34
        query.accountMultiBalance("account", "balance",
                accounts?.get(0), "latest").let { query.fetchAccountMultiBalance()?.result }
    }

    override fun getBlocks(account: String?): ArrayList<Blocks>? = let { //todo #29
        query.accountBlock("account", "getminedblocks",
                account, "blocks").let { query.fetchAccountBlock()?.result }
    }

    override fun getTransactions(account: String?): ArrayList<Transactions>? = let { //todo #29
        query.accountTransactions("account", "txlist",
                account, "0", "99999999",
                "asc").let { query.fetchAccountTransaction()?.result }
    }

    override fun getNetworkStatus(): String? = genericNetworkQuery.let { query.fetchAccountBalance()?.status }

    override fun getNetworkMessage(): String? = genericNetworkQuery.let { query.fetchAccountBalance()?.message }

}