package jfyg.response.account

import jfyg.model.TransactionsInternal
import jfyg.response.BaseResponse

/**
 * Internal Transactions recorded by an account
 */
class AccountInternalTransactionResponse(var result: ArrayList<TransactionsInternal>? = null) : BaseResponse() {
}