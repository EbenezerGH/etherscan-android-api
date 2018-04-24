package jfyg.network.response.account

import jfyg.data.Blocks
import jfyg.network.response.BaseResponse

/**
 * Blocks mined by an account
 */
internal data class AccountBlockResponse(var result: ArrayList<Blocks>? = null) : BaseResponse()