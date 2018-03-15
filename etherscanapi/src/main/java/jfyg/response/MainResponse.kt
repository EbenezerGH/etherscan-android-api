package jfyg.response

import com.google.gson.annotations.SerializedName

/**
 * Base response that all queries will utilize
 */
class MainResponse {

    var status: String? = null

    var message: String? = null

    @SerializedName("result") //TODO Issue #26
    var statResult: StatResponse? = null

}