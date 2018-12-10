package jfyg.network.response

import jfyg.data.BlockMined

/**
 * Check contract execution status
 */
data class BlockResponse(val result: BlockMined) : BaseResponse()