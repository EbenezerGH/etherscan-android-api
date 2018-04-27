package jfyg.data.account

import io.reactivex.Single
import jfyg.data.Balance
import jfyg.data.BlockAccount
import jfyg.data.ERC20Token
import jfyg.data.Tx
import jfyg.data.TxsInternal

/**
 * https://etherscan.io/apis#accounts
 */
internal interface AccountsContract {

    /**
     * Get Ether Balance for a single Address
     */
    fun getBalance(address: String?): Single<Double>

    /**
     * Get Ether Balance for multiple Addresses in a single call
     */
    fun getMultiBalance(addresses: List<String>?): Single<List<Balance>>

    /**
     * Get list of blocks mined by address
     */
    fun getBlocks(address: String?): Single<List<BlockAccount>>

    /**
     * Get a list of 'Normal' Transactions By Address
     */
    fun getTransactions(address: String?): Single<List<Tx>>

    /**
     * [BETA] Get a list of "ERC20 - Token Transfer Events" by Address
     */
    fun getERC20Tokens(address: String?): Single<List<ERC20Token>>

    /**
     * [BETA] Get a list of 'Internal' Transactions by Address
     */
    fun getInternalTransactions(address: String?): Single<List<TxsInternal>>

    /**
     * Return network status
     */
    fun getNetworkStatus(): Single<String>

    /**
     * Return network message
     */
    fun getNetworkMessage(): Single<String>
}