package jfyg.queries

import io.reactivex.disposables.Disposable
import jfyg.response.MainResponse

interface StatQueries {

    fun stats(module: String, action: String): Disposable?

    fun handleResponse(response: MainResponse)

}