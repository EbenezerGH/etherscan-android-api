package jfyg.data.transaction

import io.reactivex.Single
import jfyg.data.TxExecutionStatus
import jfyg.data.TxReceiptStatus
import jfyg.network.queries.ApiQuery
import jfyg.utils.GET_STATUS
import jfyg.utils.GET_TX_RECEIPT_STATUS
import jfyg.utils.TRANSACTION
import jfyg.utils.TRANSACTION_PUBLIC_ADDRESS

/**
 * https://etherscan.io/apis#transactions
 */
class Transactions : TransactionsContract {

    private val query = ApiQuery()
    private val genericNetworkQuery = query.txReceiptStatus(
            TRANSACTION,
            GET_STATUS,
            TRANSACTION_PUBLIC_ADDRESS)

    /**
     * [BETA] Check Contract Execution Status (if there was an error during contract execution)
     * Note: isError":"0" = Pass , isError":"1" = Error during Contract Execution
     */
    override fun getTxExecutionStatus(txHash: String):
            Single<TxExecutionStatus> = query.txExecutionStatus(
            TRANSACTION,
            GET_STATUS,
            txHash).map { it.result }

    /**
     * [BETA] Check Transaction Receipt Status (Only applicable for Post Byzantium fork transactions)
     * Note: status: 0 = Fail, 1 = Pass. Will return null/empty value for pre-byzantium fork
     */
    override fun getTxReceiptStatus(txHash: String):
            Single<TxReceiptStatus> = query.txReceiptStatus(
            TRANSACTION,
            GET_TX_RECEIPT_STATUS,
            txHash).map { it.result }

    /**
     * Return network status
     */
    override fun getNetworkStatus(): Single<String> = genericNetworkQuery.map { it.status }

    /**
     * Return network message
     */
    override fun getNetworkMessage(): Single<String> = genericNetworkQuery.map { it.message }

}