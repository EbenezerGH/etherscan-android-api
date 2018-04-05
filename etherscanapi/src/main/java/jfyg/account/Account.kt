package jfyg.account

import android.annotation.SuppressLint
import jfyg.model.Balances
import jfyg.model.Blocks
import jfyg.model.Transactions
import jfyg.queries.QueryMediator

class Account : AccountContract {
    private var query = QueryMediator()

    override fun getBalance(account: String?): Double? {
        query.accountBalance("account",
                "balance",
                account,
                "latest")

        return query.fetchAccountBalance()?.result?.toDouble()
    }

    override fun getMultiBalance(accounts: List<String>?): ArrayList<Balances>? {
        query.accountMultiBalance("account",
                "balance",
                accounts?.get(0), //todo #34
                "latest")

        return query.fetchAccountMultiBalance()?.result
    }

    override fun getBlocks(account: String?): ArrayList<Blocks>? {
        query.accountBlock("account",
                "getminedblocks",
                account,
                "blocks")

        return query.fetchAccountBlock()?.result
    }

    override fun getTransactions(account: String?): ArrayList<Transactions>? {
        query.accountTransactions("account",
                "txlist",
                account,
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