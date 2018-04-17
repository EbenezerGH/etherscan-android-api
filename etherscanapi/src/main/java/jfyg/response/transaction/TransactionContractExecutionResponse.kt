package jfyg.response.transaction

import jfyg.model.TxExecutionStatus
import jfyg.response.BaseResponse

/**
 * Check Contract Execution Status
 */
internal data class TransactionContractExecutionResponse(var result: TxExecutionStatus) : BaseResponse()