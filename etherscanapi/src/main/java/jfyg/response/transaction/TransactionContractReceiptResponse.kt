package jfyg.response.transaction

import jfyg.model.TxReceiptStatus
import jfyg.response.BaseResponse

/**
 * Check Contract Receipt Status
 */
internal data class TransactionContractReceiptResponse(var result: TxReceiptStatus) : BaseResponse()