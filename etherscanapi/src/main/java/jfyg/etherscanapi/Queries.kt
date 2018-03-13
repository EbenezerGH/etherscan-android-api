package jfyg.etherscanapi

import android.content.ContentValues.TAG
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jfyg.etherscanapi.model.EtherPriceModel
import jfyg.etherscanapi.network.RestClient
import jfyg.etherscanapi.responses.MainResponse

/**
 * //TODO documentation
 */
class Queries {
    private var etherPrice = EtherPriceModel()

    fun stats(module: String, action: String) {
        RestClient().getQuery()
                .getEtherStats(module, action, ApiKey.takeOff.callApiKey())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
    }

    private fun handleResponse(retrieveQuery: MainResponse) {
        etherPrice.status = retrieveQuery.status
        etherPrice.message = retrieveQuery.message
        etherPrice.ethBtc = retrieveQuery.etherPriceresult?.ethBtc
        etherPrice.ethBtcTimestamp = retrieveQuery.etherPriceresult?.ethBtcTimestamp
        etherPrice.ethUsd = retrieveQuery.etherPriceresult?.ethUsd
        etherPrice.ethUsdTimestamp = retrieveQuery.etherPriceresult?.ethUsdTimestamp
    }

    private fun handleError(error: Throwable) {
        Log.d(TAG, "The error " + error.message)
    }

    fun fetchEtherStats(): EtherPriceModel {
        return etherPrice
    }
}