package jfyg.response.account

import jfyg.model.Blocks
import jfyg.response.BaseResponse

/**
 * Blocks mined by an account
 */
internal data class AccountBlockResponse(var result: ArrayList<Blocks>? = null) : BaseResponse()