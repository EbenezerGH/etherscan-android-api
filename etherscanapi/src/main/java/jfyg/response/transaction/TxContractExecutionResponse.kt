package jfyg.response.transaction

import jfyg.model.TxExecutionStatus
import jfyg.response.BaseResponse

/**
 * Check contract execution status
 */
internal data class TxContractExecutionResponse(var result: TxExecutionStatus) : BaseResponse()