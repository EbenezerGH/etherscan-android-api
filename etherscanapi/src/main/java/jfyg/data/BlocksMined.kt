package jfyg.data

/**
 * https://etherscan.io/apis#blocks
 */
data class BlocksMined(var blockNumber: String? = null,
                       var timeStamp: String? = null,
                       var blockMiner: String? = null,
                       var blockReward: String? = null,
                       var uncles: ArrayList<Uncles>? = null)