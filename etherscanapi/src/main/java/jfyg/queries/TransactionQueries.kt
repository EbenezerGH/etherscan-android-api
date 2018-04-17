package jfyg.queries

import io.reactivex.Single
import jfyg.response.transaction.TransactionContractExecutionResponse
import jfyg.response.transaction.TransactionContractReceiptResponse

internal interface TransactionQueries {

    /**
     * Check Contract Execution Status
     */
    fun transactionContractExecutionStatus(module: String?,
                                           action: String?,
                                           txHash: String?): Single<TransactionContractExecutionResponse>
    /**
     * Check Contract Receipt Status
     */
    fun transactionContractReceiptStatus(module: String?,
                                         action: String?,
                                         txHash: String?): Single<TransactionContractReceiptResponse>


}