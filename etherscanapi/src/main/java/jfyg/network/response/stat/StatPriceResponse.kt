package jfyg.network.response.stat

import jfyg.data.StatPrice
import jfyg.network.response.BaseResponse

/**
 * Response for stat
 */
internal data class StatPriceResponse(val result: StatPrice? = null) : BaseResponse()