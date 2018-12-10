package jfyg.data.transaction

import jfyg.network.queries.ApiQuery
import jfyg.network.response.TxContractExecutionResponse
import jfyg.network.response.TxContractReceiptResponse
import jfyg.utils.GET_STATUS
import jfyg.utils.GET_TX_RECEIPT_STATUS
import jfyg.utils.TRANSACTION
import jfyg.utils.TRANSACTION_PUBLIC_ADDRESS
import retrofit2.Response

/**
 * https://etherscan.io/apis#transactions
 */
class TransactionsApi : TransactionsContract {

    private val query = ApiQuery()

    /**
     * [BETA] Check Contract Execution Status (if there was an error during contract execution)
     * Note: isError":"0" = Pass , isError":"1" = Error during Contract Execution
     */
    override suspend fun getTxExecutionStatus(txHash: String):
            Response<TxContractExecutionResponse> = query.txExecutionStatus(
            TRANSACTION,
            GET_STATUS,
            txHash)

    /**
     * [BETA] Check Transaction Receipt Status (Only applicable for Post Byzantium fork transactions)
     * Note: status: 0 = Fail, 1 = Pass. Will return null/empty value for pre-byzantium fork
     */
    override suspend fun getTxReceiptStatus(txHash: String):
            Response<TxContractReceiptResponse> = query.txReceiptStatus(
            TRANSACTION,
            GET_TX_RECEIPT_STATUS,
            txHash)

    /**
     * Return network status
     */
    override suspend fun getNetworkStatus(): Response<TxContractReceiptResponse> = query.txReceiptStatus(
            TRANSACTION,
            GET_STATUS,
            TRANSACTION_PUBLIC_ADDRESS)

    /**
     * Return network message
     */
    override suspend fun getNetworkMessage(): Response<TxContractReceiptResponse> = query.txReceiptStatus(
            TRANSACTION,
            GET_STATUS,
            TRANSACTION_PUBLIC_ADDRESS)

}