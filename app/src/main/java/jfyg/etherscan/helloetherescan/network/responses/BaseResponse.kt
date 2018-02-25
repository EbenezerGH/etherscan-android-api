package jfyg.etherscan.helloetherescan.network.responses

import com.google.gson.annotations.SerializedName

/**
 * Base response that all queries will utilize
 */
open class BaseResponse {

    @SerializedName("status")
    var status: String = ""

    @SerializedName("message")
    var message: String = ""

    @SerializedName("result")
    open var etherPriceresult: EtherPriceResponse? = null

    //TODO: Figure out how to handle the same response name coming in from different queries
    //@SerializedName("result")
    //open var etherSupplyResult: String = ""
}