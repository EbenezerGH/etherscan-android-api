package jfyg.network.response

import jfyg.data.StatPrice

/**
 * Response for stat
 */
data class StatPriceResponse(val result: StatPrice) : BaseResponse()

/**
 * Response for total supply of ether
 */
data class StatSupplyResponse(val result: String) : BaseResponse()