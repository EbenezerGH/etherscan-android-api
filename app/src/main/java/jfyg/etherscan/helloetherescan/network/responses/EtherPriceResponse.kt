package jfyg.etherscan.helloetherescan.network.responses

import com.google.gson.annotations.SerializedName

/**
 * Response for Ether prices
 */
class EtherPriceResponse {

    @SerializedName("ethbtc")
    var ethBtc: String = ""

    @SerializedName("ethbtc_timestamp")
    var ethBtcTimestamp: String = ""

    @SerializedName("ethusd")
    var ethUsd: String = ""

    @SerializedName("ethusd_timestamp")
    var ethUsdTimestamp: String = ""
}