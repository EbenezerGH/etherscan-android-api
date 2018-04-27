package jfyg.network.response.account

import jfyg.data.Tx
import jfyg.network.response.BaseResponse

/**
 * Transactions recorded by an account
 */
internal data class AccountTxResponse(var result: List<Tx>? = null) : BaseResponse()