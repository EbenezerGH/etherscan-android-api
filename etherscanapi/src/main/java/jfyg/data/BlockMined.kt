package jfyg.data

data class BlockMined(val blockNumber: String? = null,

                      val timeStamp: String? = null,

                      val blockMiner: String? = null,

                      val blockReward: String? = null,

                      val uncles: List<Uncle> = emptyList())