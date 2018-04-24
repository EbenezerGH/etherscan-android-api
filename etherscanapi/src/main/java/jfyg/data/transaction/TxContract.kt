package jfyg.data.transaction

import io.reactivex.Single
import jfyg.data.TxExecutionStatus
import jfyg.data.TxReceiptStatus

/**
 * https://etherscan.io/apis#transactions
 */
interface TxContract {

    /**
     * [BETA] Check Contract Execution Status (if there was an error during contract execution)
     * Note: isError":"0" = Pass , isError":"1" = Error during Contract Execution
     */
    fun getTxExecutionStatus(txHash: String): Single<TxExecutionStatus>

    /**
     * [BETA] Check Transaction Receipt Status (Only applicable for Post Byzantium fork transactions)
     * Note: status: 0 = Fail, 1 = Pass. Will return null/empty value for pre-byzantium fork
     */
    fun getTxReceiptStatus(txHash: String): Single<TxReceiptStatus>

    /**
     * Return network status
     */
    fun getNetworkStatus(): Single<String>

    /**
     * Return network message
     */
    fun getNetworkMessage(): Single<String>
}