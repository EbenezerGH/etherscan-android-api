package jfyg.etherscan.helloetherescan.model

import com.google.gson.annotations.SerializedName

/**
 * Response that is common throughout all queries
 */
open class BaseResponse {
    @SerializedName("status")
    var status: String = ""

    @SerializedName("message")
    var message: String = ""
}