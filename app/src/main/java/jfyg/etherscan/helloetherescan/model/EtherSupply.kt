package jfyg.etherscan.helloetherescan.model

import com.google.gson.annotations.SerializedName

/**
 * Model for the total supply of Ether
 */
class EtherSupply : BaseResponse() {
    @SerializedName("ethbtc")
    var result: Int = 0

}