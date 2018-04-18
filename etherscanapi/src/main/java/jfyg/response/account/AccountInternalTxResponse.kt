package jfyg.response.account

import jfyg.model.TxsInternal
import jfyg.response.BaseResponse

/**
 * Internal Transactions recorded by an account
 */
internal class AccountInternalTxResponse(var result: ArrayList<TxsInternal>? = null) : BaseResponse()