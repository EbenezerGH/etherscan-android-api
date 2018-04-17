package jfyg.queries

import io.reactivex.Single
import jfyg.response.contract.SmartContractResponse

internal interface SmartContractQueries {

    /**
     * Get ABI for a contracts from a given address
     */
    fun abiContract(module: String?,
                    action: String?,
                    address: String?): Single<SmartContractResponse>

}