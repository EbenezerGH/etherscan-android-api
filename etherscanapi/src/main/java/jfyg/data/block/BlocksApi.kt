package jfyg.data.block

import jfyg.network.queries.ApiQuery
import jfyg.network.response.BlockResponse
import jfyg.utils.BLOCK
import jfyg.utils.BLOCK_NO
import jfyg.utils.GET_BLOCK_REWARD
import retrofit2.Response

/**
 * https://etherscan.io/apis#blocks
 */
class BlocksApi : BlocksContract {
    private val query = ApiQuery()

    /**
     * [BETA] Get Block And Uncle Rewards by BlockNo
     */
    override suspend fun getBlocksMined(blockNo: String):
            Response<BlockResponse> = query.blocksMined(
            BLOCK,
            GET_BLOCK_REWARD,
            blockNo)

    /**
     * Return network status
     */
    override suspend fun getNetworkStatus(): Response<BlockResponse> = query.blocksMined(
            BLOCK,
            GET_BLOCK_REWARD,
            BLOCK_NO)

    /**
     * Return network message
     */
    override suspend fun getNetworkMessage(): Response<BlockResponse> = query.blocksMined(
            BLOCK,
            GET_BLOCK_REWARD,
            BLOCK_NO)

}