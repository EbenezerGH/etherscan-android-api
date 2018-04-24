package jfyg.network.queries

import io.reactivex.Single
import jfyg.network.response.contract.ContractABIResponse

internal interface ContractABIApi {

    /**
     * Get ABI for a contracts from a given address
     */
    fun contractABI(module: String?,
                    action: String?,
                    address: String?): Single<ContractABIResponse>

}