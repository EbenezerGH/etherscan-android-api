package jfyg.network.response

import jfyg.data.TxExecutionStatus
import jfyg.data.TxReceiptStatus
import jfyg.network.response.BaseResponse

/**
 * Check contract receipt status
 */
internal data class TxContractReceiptResponse(val result: TxReceiptStatus) : BaseResponse()

/**
 * Check contract execution status
 */
internal data class TxContractExecutionResponse(val result: TxExecutionStatus) : BaseResponse()