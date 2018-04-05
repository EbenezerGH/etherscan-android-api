package jfyg.response.account

import jfyg.response.BaseResponse

/**
 * Balance of Ether existing in an account
 */
data class AccountBalanceResponse(var result: String? = null) : BaseResponse()