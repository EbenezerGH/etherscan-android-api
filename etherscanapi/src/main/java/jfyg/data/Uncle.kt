package jfyg.data

import com.squareup.moshi.Json

data class Uncle(val miner: String,

                 val unclePosition: String,

                 @field:Json(name = "blockreward")
                 val blockReward: String
)