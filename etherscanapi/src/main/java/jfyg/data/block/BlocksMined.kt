package jfyg.data.block

import io.reactivex.Single
import jfyg.data.BlocksMined
import jfyg.network.queries.ApiQuery

/**
 * https://etherscan.io/apis#blocks
 */
class BlocksMined : BlocksMinedContract {
    private val query = ApiQuery()

    /**
     * [BETA] Get Block And Uncle Rewards by BlockNo
     */
    override fun getBlocksMined(blockNo: String?): Single<BlocksMined> =
        query.blocksMined("block", "getblockreward", blockNo).map { it.result }

}