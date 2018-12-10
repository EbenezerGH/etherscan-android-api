package jfyg.network.queries

import jfyg.network.response.ContractResponse
import retrofit2.Response

/**
 * Newly verified Contracts are synced to the API servers within 5 minutes or less
 * https://etherscan.io/apis#contracts
 */
internal interface ContractsApi {

    /**
     * Get Contract ABI for Verified Contract Source Codes
     * https://etherscan.io/contractsVerified
     */
    suspend fun contractABI(module: String,
                    action: String,
                    address: String): Response<ContractResponse>

}