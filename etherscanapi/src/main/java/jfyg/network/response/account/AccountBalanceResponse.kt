package jfyg.network.response.account

import jfyg.network.response.BaseResponse

/**
 * Balance of Ether existing in an account
 */
internal data class AccountBalanceResponse(val result: String? = null) : BaseResponse()