package jfyg.network.response.account

import jfyg.data.Txs
import jfyg.network.response.BaseResponse

/**
 * Transactions recorded by an account
 */
internal data class AccountTxResponse(var result: ArrayList<Txs>? = null) : BaseResponse()