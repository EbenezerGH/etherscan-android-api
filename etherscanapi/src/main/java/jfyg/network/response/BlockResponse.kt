package jfyg.network.response

import jfyg.data.BlockMined
import jfyg.network.response.BaseResponse

/**
 * Check contract execution status
 */
internal data class BlockResponse(val result: BlockMined) : BaseResponse()