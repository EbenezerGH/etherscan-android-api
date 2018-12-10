package jfyg.data

data class BlockMined(val blockNumber: String,

                      val timeStamp: String,

                      val blockMiner: String,

                      val blockReward: String,

                      val uncles: List<Uncle> = emptyList()
)