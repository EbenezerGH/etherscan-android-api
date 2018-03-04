package jfyg.etherscan.helloetherescan

import android.util.Log

class ApiKey private constructor() {
    private object Holder {
        val TakeOff = ApiKey()
    }

    companion object {
        val takeOff: ApiKey by lazy { Holder.TakeOff }
    }

    private var apiKey: String? = null

    fun callApiKey(): String? {
        if (apiKey == null) {
            Log.w("", "No api key seems to be added.  No record of your queries will be kept in your " +
                    "https://etherscan.io/ console")
        }
        return ApiKey.takeOff.apiKey
    }

    fun setApiKey(apiKey: String) {
        this.apiKey = apiKey
    }

}