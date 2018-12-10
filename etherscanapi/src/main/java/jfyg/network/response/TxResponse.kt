package jfyg.network.response

import jfyg.data.TxExecutionStatus
import jfyg.data.TxReceiptStatus

/**
 * Check contract receipt status
 */
data class TxContractReceiptResponse(val result: TxReceiptStatus) : BaseResponse()

/**
 * Check contract execution status
 */
data class TxContractExecutionResponse(val result: TxExecutionStatus) : BaseResponse()