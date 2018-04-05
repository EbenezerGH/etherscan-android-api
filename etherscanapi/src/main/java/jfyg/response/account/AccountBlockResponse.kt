package jfyg.response.account

import jfyg.model.Blocks
import jfyg.response.BaseResponse

/**
 * Blocks mined by an account
 */
data class AccountBlockResponse(var result: ArrayList<Blocks>? = null) : BaseResponse()