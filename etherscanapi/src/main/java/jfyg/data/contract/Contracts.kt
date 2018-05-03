package jfyg.data.contract

import io.reactivex.Single
import jfyg.network.queries.ApiQuery
import jfyg.utils.CONTRACT
import jfyg.utils.CONTRACT_PUBLIC_ADDRESS
import jfyg.utils.GET_ABI

/**
 * Newly verified Contracts are synced to the API servers within 5 minutes or less
 * https://etherscan.io/apis#contracts
 */
class Contracts : ContractsContract {

    private val query = ApiQuery()
    private val abiQuery = query.contractABI(
            CONTRACT,
            GET_ABI,
            CONTRACT_PUBLIC_ADDRESS)

    /**
     * Get Contract ABI for Verified Contract Source Codes
     * https://etherscan.io/contractsVerified
     */
    override fun getContractABI(address: String):
            Single<String> = query.contractABI(
            CONTRACT,
            GET_ABI,
            address).map { it.result }

    /**
     * Return network status
     */
    override fun getNetworkStatus(): Single<String> = abiQuery.map { it.status }

    /**
     * Return network message
     */
    override fun getNetworkMessage(): Single<String> = abiQuery.map { it.message }

}