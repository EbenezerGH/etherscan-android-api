package jfyg.account

import jfyg.model.Balances
import jfyg.model.Blocks
import jfyg.model.Transactions
import jfyg.queries.QueryMediator

class Account : AccountContract {
    private var query = QueryMediator()

    override fun getBalance(address: String?): Double? {
        query.accountBalance("account",
                "balance",
                address,
                "latest")

        return query.fetchAccountBalance()?.result?.toDouble()
    }

    override fun getMultiBalance(address: List<String>?): ArrayList<Balances>? {
        query.accountMultiBalance("account",
                "balance",
                address?.get(0), //todo #34
                "latest")

        return query.fetchAccountMultiBalance()?.result
    }

    override fun getBlocks(address: String?): ArrayList<Blocks>? {
        query.accountBlock("account",
                "getminedblocks",
                address,
                "blocks")

        return query.fetchAccountBlock()?.result
    }

    override fun getTransactions(address: String?): ArrayList<Transactions>? {
        query.accountTransactions("account",
                "txlist",
                address,
                "0",
                "99999999",
                "asc")
        return query.fetchAccountTransaction()?.result
    }

    override fun getNetworkStatus(): String? {
        query.accountBalance("account",
                "balance",
                "0x82e4499D4b2A669831a3881d61BB24f7b620c61a",
                "latest")

        return query.fetchAccountBalance()?.status
    }

    override fun getNetworkMessage(): String? {
        query.accountBalance("account",
                "balance",
                "0x82e4499D4b2A669831a3881d61BB24f7b620c61a",
                "latest")

        return query.fetchAccountBalance()?.message
    }

}