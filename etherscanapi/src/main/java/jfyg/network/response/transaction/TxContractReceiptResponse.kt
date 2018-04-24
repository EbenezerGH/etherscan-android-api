package jfyg.network.response.transaction

import jfyg.data.TxReceiptStatus
import jfyg.network.response.BaseResponse

/**
 * Check contract receipt status
 */
internal data class TxContractReceiptResponse(var result: TxReceiptStatus) : BaseResponse()