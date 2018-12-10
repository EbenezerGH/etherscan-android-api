package jfyg.data.block

import jfyg.network.response.BlockResponse
import retrofit2.Response

/**
 * https://etherscan.io/apis#blocks
 */
internal interface BlocksContract {

    /**
     * [BETA] Get Block And Uncle Rewards by BlockNo
     */
    suspend fun getBlocksMined(blockNo: String): Response<BlockResponse>

    /**
     * Return network status
     */
    suspend fun getNetworkStatus(): Response<BlockResponse>

    /**
     * Return network message
     */
    suspend fun getNetworkMessage(): Response<BlockResponse>

}