package jfyg.data

import com.google.gson.annotations.SerializedName

data class StatPrice(@SerializedName("ethbtc")
                     val ethBtc: String? = null,

                     @SerializedName("ethbtc_timestamp")
                     val ethBtcTimestamp: String? = null,

                     @SerializedName("ethusd")
                     val ethUsd: String? = null,

                     @SerializedName("ethusd_timestamp")
                     val ethUsdTimestamp: String? = null
)