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
    fun getBalance(address: String?): Single<Double>

    /**
     * Return balances of multiple accounts separated by commas
     */
    fun getMultiBalance(addresses: ArrayList<String>?): Single<ArrayList<Balances>>

    /**
     * Get list of blocks mined by address
     */
    fun getBlocks(address: String?): Single<ArrayList<Blocks>>

    /**
     * Get a list of 'Normal' Transactions By Address
     */
    fun getTransactions(address: String?): Single<ArrayList<Transactions>>

    /**
     * Get a list of 'Internal' Transactions by Address
     */
    fun getInternalTransactions(address: String?): Single<ArrayList<TransactionsInternal>>

}