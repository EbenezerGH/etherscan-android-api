package jfyg.response.stat

import jfyg.model.StatPrice
import jfyg.response.BaseResponse

/**
 * Responses for Stat
 */
internal data class StatPriceResponse(var result: StatPrice? = null) : BaseResponse()