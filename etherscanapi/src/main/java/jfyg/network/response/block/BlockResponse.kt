package jfyg.network.response.block

import jfyg.data.BlocksMined
import jfyg.network.response.BaseResponse

/**
 * Check contract execution status
 */
internal data class BlockResponse(var result: BlocksMined) : BaseResponse()