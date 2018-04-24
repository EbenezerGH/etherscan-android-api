package jfyg.network.queries

import io.reactivex.Single
import jfyg.network.response.transaction.TxContractExecutionResponse
import jfyg.network.response.transaction.TxContractReceiptResponse

internal interface TxApi {

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