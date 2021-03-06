package jfyg.network.response.account

import jfyg.data.BlockAccount
import jfyg.network.response.BaseResponse

/**
 * Blocks mined by an account
 */
internal data class AccountBlockResponse(val result: List<BlockAccount>? = null) : BaseResponse()