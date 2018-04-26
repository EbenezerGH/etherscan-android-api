package jfyg.data.block

import io.reactivex.Single
import jfyg.data.BlocksMined

/**
 * https://etherscan.io/apis#blocks
 */
internal interface BlocksMinedContract {

    /**
     * [BETA] Get Block And Uncle Rewards by BlockNo
     */
    fun getBlocksMined(blockNo: String?): Single<BlocksMined>

}