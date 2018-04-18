package jfyg.response.stat

import jfyg.model.StatPrice
import jfyg.response.BaseResponse

/**
 * Response for stat
 */
internal data class StatPriceResponse(var result: StatPrice? = null) : BaseResponse()