package jfyg.queries

import io.reactivex.Single
import jfyg.response.transaction.TxContractExecutionResponse
import jfyg.response.transaction.TxContractReceiptResponse

internal interface TxQueries {

    /**
     * Check contract execution status
     */
    fun txExecutionStatus(module: String?,
                          action: String?,
                          txHash: String?): Single<TxContractExecutionResponse>
    /**
     * Check contract receipt status
     */
    fun txReceiptStatus(module: String?,
                        action: String?,
                        txHash: String?): Single<TxContractReceiptResponse>


}