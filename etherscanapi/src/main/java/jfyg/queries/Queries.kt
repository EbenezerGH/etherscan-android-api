package jfyg.queries

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import jfyg.ApiKey
import jfyg.network.RestClient
import jfyg.response.MainResponse

/**
 * A mediator between the responses and errors that come from every query
 */
class Queries : StatQueries {
    private val TAG = javaClass.name

    private var statInfo = MainResponse()

    override fun stats(module: String, action: String): Disposable =
            RestClient().getQuery()
                    .getEtherStats(module, action, ApiKey.takeOff.callApiKey())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe(this::handleResponse, this::handleError)


    override fun handleResponse(response: MainResponse) { //TODO #27
        statInfo = response
    }

    private fun handleError(error: Throwable) {
        Log.d(TAG, "The error " + error.message)
    }

    fun fetchStatResponse(): MainResponse? = statInfo

}