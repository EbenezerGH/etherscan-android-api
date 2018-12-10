package jfyg.data.transaction

import jfyg.network.response.TxContractExecutionResponse
import jfyg.network.response.TxContractReceiptResponse
import retrofit2.Response

/**
 * https://etherscan.io/apis#transactions
 */
interface TransactionsContract {

    /**
     * [BETA] Check Contract Execution Status (if there was an error during contract execution)
     * Note: isError":"0" = Pass , isError":"1" = Error during Contract Execution
     */
    suspend fun getTxExecutionStatus(txHash: String): Response<TxContractExecutionResponse>

    /**
     * [BETA] Check Transaction Receipt Status (Only applicable for Post Byzantium fork transactions)
     * Note: status: 0 = Fail, 1 = Pass. Will return null/empty value for pre-byzantium fork
     */
    suspend fun getTxReceiptStatus(txHash: String): Response<TxContractReceiptResponse>

    /**
     * Return network status
     */
    suspend fun getNetworkStatus(): Response<TxContractReceiptResponse>

    /**
     * Return network message
     */
    suspend fun getNetworkMessage(): Response<TxContractReceiptResponse>
}