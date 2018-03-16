package jfyg

import android.util.Log

/**
 * Retrieves and stores the user's Api key
 */
class ApiKey private constructor() {
    private val TAG = javaClass.name

    private var apiKey: String? = null

    private object Holder {
        val TakeOff = ApiKey()
    }

    companion object {
        val takeOff: ApiKey by lazy { Holder.TakeOff }
    }

    fun callApiKey(): String? {
        if (apiKey == null) {
            Log.w(TAG, "No api key seems to be added.  No record of your queries will be kept in your " +
                    "https://etherscan.io/ console")
        }
        return takeOff.apiKey
    }

    fun setApiKey(apiKey: String) {
        this.apiKey = apiKey
    }

}