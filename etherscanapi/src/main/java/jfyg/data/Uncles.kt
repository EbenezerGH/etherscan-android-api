package jfyg.data

import com.google.gson.annotations.SerializedName

data class Uncles(var miner: String? = null,

                  var unclePosition: String? = null,

                  @SerializedName("blockreward")
                  var blockReward: String? = null)