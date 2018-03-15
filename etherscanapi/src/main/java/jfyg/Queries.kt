package jfyg

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import jfyg.model.StatModel
import jfyg.network.RestClient
import jfyg.response.MainResponse

/**
 * A mediator between the responses and errors that come from every query
 */
class Queries : StatQueries {
    private val TAG = javaClass.name

    private var statInfo = StatModel()

    override fun stats(module: String, action: String): Disposable =
            RestClient().getQuery()
                    .getEtherStats(module, action, ApiKey.takeOff.callApiKey())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(this::handleResponse, this::handleError)


    override fun handleResponse(retrieveQuery: MainResponse) { //TODO #27
        statInfo.status = retrieveQuery.status
        statInfo.message = retrieveQuery.message
        statInfo.ethBtc = retrieveQuery.statResult?.ethBtc
        statInfo.ethBtcTimestamp = retrieveQuery.statResult?.ethBtcTimestamp
        statInfo.ethUsd = retrieveQuery.statResult?.ethUsd
        statInfo.ethUsdTimestamp = retrieveQuery.statResult?.ethUsdTimestamp
    }

    private fun handleError(error: Throwable) {
        Log.d(TAG, "The error " + error.message)
    }

    fun fetchStats(): StatModel? = statInfo

    fun fetchNetworkInfo(): String? = "status: ${statInfo.status} :: message: ${statInfo.message}"

}