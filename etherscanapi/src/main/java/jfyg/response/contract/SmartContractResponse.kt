package jfyg.response.contract

import jfyg.response.BaseResponse

/**
 * Encoded Solidity Contract call (ABI)
 */
internal data class SmartContractResponse(var result: String? = null) : BaseResponse()