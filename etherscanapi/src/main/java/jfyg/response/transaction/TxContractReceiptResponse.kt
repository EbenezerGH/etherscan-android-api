package jfyg.response.transaction

import jfyg.model.TxReceiptStatus
import jfyg.response.BaseResponse

/**
 * Check contract receipt status
 */
internal data class TxContractReceiptResponse(var result: TxReceiptStatus) : BaseResponse()