package jfyg.data

import com.google.gson.annotations.SerializedName

data class Uncle(val miner: String,

                 val unclePosition: String,

                 @SerializedName("blockreward")
                 val blockReward: String)