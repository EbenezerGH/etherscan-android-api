package jfyg.network.queries

import jfyg.network.response.BlockResponse
import retrofit2.Response

/**
 * https://etherscan.io/apis#blocks
 */
internal interface BlocksApi {

    /**
     * [BETA] Get Block And Uncle Rewards by BlockNo
     */
    suspend fun blocksMined(module: String,
                    action: String,
                    blockno: String): Response<BlockResponse>

}