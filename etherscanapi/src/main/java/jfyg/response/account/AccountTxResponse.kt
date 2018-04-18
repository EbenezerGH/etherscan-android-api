package jfyg.response.account

import jfyg.model.Txs
import jfyg.response.BaseResponse

/**
 * Transactions recorded by an account
 */
internal data class AccountTxResponse(var result: ArrayList<Txs>? = null) : BaseResponse()