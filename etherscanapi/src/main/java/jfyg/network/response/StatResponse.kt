package jfyg.network.response

import jfyg.data.StatPrice
import jfyg.network.response.BaseResponse

/**
 * Response for stat
 */
internal data class StatPriceResponse(val result: StatPrice? = null) : BaseResponse()

/**
 * Response for total supply of ether
 */
internal data class StatSupplyResponse(val result: String? = null)