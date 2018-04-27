package jfyg.data.block

import io.reactivex.Single
import jfyg.data.BlockMined

/**
 * https://etherscan.io/apis#blocks
 */
internal interface BlocksContract {

    /**
     * [BETA] Get Block And Uncle Rewards by BlockNo
     */
    fun getBlocksMined(blockNo: String?): Single<BlockMined>

    /**
     * Return network status
     */
    fun getNetworkStatus(): Single<String>

    /**
     * Return network message
     */
    fun getNetworkMessage(): Single<String>

}