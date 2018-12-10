package jfyg.data.contract

import jfyg.network.queries.ApiQuery
import jfyg.network.response.ContractResponse
import jfyg.utils.CONTRACT
import jfyg.utils.CONTRACT_PUBLIC_ADDRESS
import jfyg.utils.GET_ABI
import retrofit2.Response

/**
 * Newly verified Contracts are synced to the API servers within 5 minutes or less
 * https://etherscan.io/apis#contracts
 */
class ContractsApi : ContractsContract {

    private val query = ApiQuery()

    /**
     * Get Contract ABI for Verified Contract Source Codes
     * https://etherscan.io/contractsVerified
     */
    override suspend fun getContractABI(address: String):
            Response<ContractResponse> = query.contractABI(
            CONTRACT,
            GET_ABI,
            address)

    /**
     * Return network status
     */
    override suspend fun getNetworkStatus(): Response<ContractResponse> = query.contractABI(
            CONTRACT,
            GET_ABI,
            CONTRACT_PUBLIC_ADDRESS)

    /**
     * Return network message
     */
    override suspend fun getNetworkMessage(): Response<ContractResponse> = query.contractABI(
            CONTRACT,
            GET_ABI,
            CONTRACT_PUBLIC_ADDRESS)

}