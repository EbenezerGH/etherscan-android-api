package jfyg.etherscan.helloetherescan.network.responses

import com.google.gson.annotations.SerializedName

/**
 * Base response that all queries will utilize
 */
class MainResponse {

    @SerializedName("status")
    var status: String = ""

    @SerializedName("message")
    var message: String = ""

    @SerializedName("result")
    var etherPriceresult: EtherPriceResponse? = null

}