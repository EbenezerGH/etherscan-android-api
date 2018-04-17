package jfyg.transaction

import io.reactivex.Single
import jfyg.model.TxExecutionStatus
import jfyg.model.TxReceiptStatus

interface TransactionContract {

    /**
     * Return transaction Execution Status
     */
    fun getTransactionExecutionStatus(txHash: String): Single<TxExecutionStatus>

    /**
     * Return transaction Receipt Status
     */
    fun getTransactionReceiptStatus(txHash: String): Single<TxReceiptStatus>

    /**
     * Return network status
     */
    fun getNetworkStatus(): Single<String>

    /**
     * Return network message
     */
    fun getNetworkMessage(): Single<String>
}