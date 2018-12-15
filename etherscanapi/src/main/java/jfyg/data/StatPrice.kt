package jfyg.data

import com.google.gson.annotations.SerializedName

data class StatPrice(@SerializedName("ethbtc")
                     val ethBtc: String,

                     @SerializedName("ethbtc_timestamp")
                     val ethBtcTimestamp: String,

                     @SerializedName("ethusd")
                     val ethUsd: String,

                     @SerializedName("ethusd_timestamp")
                     val ethUsdTimestamp: String
)