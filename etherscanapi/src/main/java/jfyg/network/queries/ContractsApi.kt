package jfyg.network.queries

import io.reactivex.Single
import jfyg.network.response.ContractResponse

/**
 * Newly verified Contracts are synced to the API servers within 5 minutes or less
 * https://etherscan.io/apis#contracts
 */
internal interface ContractsApi {

    /**
     * Get Contract ABI for Verified Contract Source Codes
     * https://etherscan.io/contractsVerified
     */
    fun contractABI(module: String,
                    action: String,
                    address: String): Single<ContractResponse>

}