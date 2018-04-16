package jfyg.queries

import io.reactivex.Single
import jfyg.response.account.AccountBalanceResponse
import jfyg.response.contract.SmartContractResponse

internal interface SmartContractQueries {

    /**
     * Get EBI for a contracts from a given address
     */
    fun abiContract(module: String?,
                    action: String?,
                    address: String?): Single<SmartContractResponse>

}