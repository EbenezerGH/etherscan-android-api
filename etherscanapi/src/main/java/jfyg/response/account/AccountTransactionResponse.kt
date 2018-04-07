package jfyg.response.account

import jfyg.model.Transactions
import jfyg.response.BaseResponse

/**
 * Transactions recorded by an account
 */
data class AccountTransactionResponse(var result: ArrayList<Transactions>? = null) : BaseResponse()