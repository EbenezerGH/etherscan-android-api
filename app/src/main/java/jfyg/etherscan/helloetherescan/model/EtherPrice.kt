package jfyg.etherscan.helloetherescan.model

import com.google.gson.annotations.SerializedName

/**
 * Model for the price of Ether
 */
class EtherPrice : BaseResponse() {
    @SerializedName("ethbtc")
    var ethBtc: Float = 0.0F

    @SerializedName("ethbtc_timestamp")
    var ethBtcTimestamp: Int = 0

    @SerializedName("ethusd")
    var ethUsd: Float = 0.0F

    @SerializedName("ethusd_timestamp")
    var ethUsdTimestamp: Int = 0
}




