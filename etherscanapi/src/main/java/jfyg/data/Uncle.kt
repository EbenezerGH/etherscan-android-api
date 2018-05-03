package jfyg.data

import com.google.gson.annotations.SerializedName

data class Uncle(val miner: String? = null,

                 val unclePosition: String? = null,

                 @SerializedName("blockreward")
                 val blockReward: String? = null)