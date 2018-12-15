package jfyg.data.block

import io.reactivex.Single
import jfyg.data.BlockMined
import jfyg.network.queries.ApiQuery
import jfyg.utils.BLOCK
import jfyg.utils.BLOCK_NO
import jfyg.utils.GET_BLOCK_REWARD

/**
 * https://etherscan.io/apis#blocks
 */
class BlocksApi : BlocksContract {
    private val query = ApiQuery()
    private val genericNetworkQuery = query.blocksMined(
            BLOCK,
            GET_BLOCK_REWARD,
            BLOCK_NO)

    /**
     * [BETA] Get Block And Uncle Rewards by BlockNo
     */
    override fun getBlocksMined(blockNo: String):
            Single<BlockMined> = query.blocksMined(
            BLOCK,
            GET_BLOCK_REWARD,
            blockNo).map { it.result }

    /**
     * Return network status
     */
    override fun getNetworkStatus(): Single<String> = genericNetworkQuery.map { it.status }

    /**
     * Return network message
     */
    override fun getNetworkMessage(): Single<String> = genericNetworkQuery.map { it.message }


}