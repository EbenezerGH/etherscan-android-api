package jfyg.network.response.account

import jfyg.data.TxsInternal
import jfyg.network.response.BaseResponse

/**
 * Internal Transactions recorded by an account
 */
internal class AccountInternalTxResponse(var result: ArrayList<TxsInternal>? = null) : BaseResponse()