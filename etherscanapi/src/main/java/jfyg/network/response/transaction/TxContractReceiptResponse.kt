package jfyg.network.response.transaction

import jfyg.data.TxReceiptStatus
import jfyg.network.response.BaseResponse

/**
 * Check contract receipt status
 */
internal data class TxContractReceiptResponse(val result: TxReceiptStatus) : BaseResponse()