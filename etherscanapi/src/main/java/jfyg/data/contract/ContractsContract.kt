package jfyg.data.contract

import jfyg.network.response.ContractResponse
import retrofit2.Response

/**
 * Newly verified Contracts are synced to the API servers within 5 minutes or less
 * https://etherscan.io/apis#contracts
 */
internal interface ContractsContract {

    /**
     * Get Contract ABI for Verified Contract Source Codes
     * https://etherscan.io/contractsVerified
     */
    suspend fun getContractABI(address: String): Response<ContractResponse>

    /**
     * Return network status
     */
    suspend fun getNetworkStatus(): Response<ContractResponse>

    /**
     * Return network message
     */
    suspend fun getNetworkMessage(): Response<ContractResponse>
}