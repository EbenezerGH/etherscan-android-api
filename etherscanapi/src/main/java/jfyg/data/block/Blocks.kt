package jfyg.data.block

import io.reactivex.Single
import jfyg.data.BlockMined
import jfyg.network.queries.ApiQuery
import jfyg.utils.Const

/**
 * https://etherscan.io/apis#blocks
 */
class Blocks : BlocksContract {
    private val query = ApiQuery()
    private val genericNetworkQuery = query.blocksMined(
            Const.BLOCK,
            Const.GET_BLOCK_REWARD,
            Const.BLOCK_NO)

    /**
     * [BETA] Get Block And Uncle Rewards by BlockNo
     */
    override fun getBlocksMined(blockNo: String?):
            Single<BlockMined> = query.blocksMined(
            Const.BLOCK,
            Const.GET_BLOCK_REWARD,
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