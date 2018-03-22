package jfyg.model

import com.google.gson.annotations.SerializedName

class StatPrice {

    @SerializedName("ethbtc")
    var ethBtc: String? = null

    @SerializedName("ethbtc_timestamp")
    var ethBtcTimestamp: String? = null

    @SerializedName("ethusd")
    var ethUsd: String? = null

    @SerializedName("ethusd_timestamp")
    var ethUsdTimestamp: String? = null

}