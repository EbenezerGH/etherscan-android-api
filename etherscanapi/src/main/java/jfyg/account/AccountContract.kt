package jfyg.account

import io.reactivex.Single
import jfyg.model.Balances
import jfyg.model.Blocks
import jfyg.model.Transactions
import jfyg.model.TransactionsInternal

internal interface AccountContract {

    /**
     * Return network status
     */
    fun getNetworkStatus(): Single<String>

    /**
     * Return network message
     */
    fun getNetworkMessage(): Single<String>

    /**
     * Return account balance
     */
    fun getBalance(account: String?): Single<Double>

    /**
     * Return balances of multiple accounts separated by commas
     */
    fun getMultiBalance(accounts: ArrayList<String>?): Single<ArrayList<Balances>>

    /**
     * Get list of blocks mined by address
     */
    fun getBlocks(account: String?): Single<ArrayList<Blocks>>

    /**
     * Get a list of 'Normal' Transactions By Address
     */
    fun getTransactions(account: String?): Single<ArrayList<Transactions>>

    /**
     * Get a list of 'Internal' Transactions by Address
     */
    fun getInternalTransactions(account: String?): Single<ArrayList<TransactionsInternal>>

}