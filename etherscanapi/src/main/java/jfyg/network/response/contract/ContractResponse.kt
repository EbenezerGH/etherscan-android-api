package jfyg.network.response.contract

import jfyg.network.response.BaseResponse

/**
 * Contract ABI encoding
 */
internal data class ContractResponse(val result: String? = null) : BaseResponse()