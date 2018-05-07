package jfyg.network.queries

import io.reactivex.Single
import jfyg.network.response.transaction.TxContractExecutionResponse
import jfyg.network.response.transaction.TxContractReceiptResponse

/**
 * https://etherscan.io/apis#transactions
 */
internal interface TransactionsApi {

    /**
     * [BETA] Check Contract Execution Status (if there was an error during contract execution)
     * Note: isError":"0" = Pass , isError":"1" = Error during Contract Execution
     */
    fun txExecutionStatus(module: String,
                          action: String,
                          txHash: String): Single<TxContractExecutionResponse>
    /**
     * [BETA] Check Transaction Receipt Status (Only applicable for Post Byzantium fork transactions)
     * Note: status: 0 = Fail, 1 = Pass. Will return null/empty value for pre-byzantium fork
     */
    fun txReceiptStatus(module: String,
                        action: String,
                        txHash: String): Single<TxContractReceiptResponse>


}