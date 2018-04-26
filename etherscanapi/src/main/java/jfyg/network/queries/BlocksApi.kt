package jfyg.network.queries

import io.reactivex.Single
import jfyg.network.response.block.BlockResponse

internal interface BlocksApi {

    /**
     * [BETA] Get Block And Uncle Rewards by BlockNo
     */
    fun blocksMined(module: String?,
                    action: String?,
                    blockno: String?): Single<BlockResponse>

}