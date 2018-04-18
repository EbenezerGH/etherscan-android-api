package jfyg.queries

import io.reactivex.Single
import jfyg.response.contract.ContractABIResponse

internal interface ContractABIQueries {

    /**
     * Get ABI for a contracts from a given address
     */
    fun contractABI(module: String?,
                    action: String?,
                    address: String?): Single<ContractABIResponse>

}