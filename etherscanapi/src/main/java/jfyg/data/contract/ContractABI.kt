package jfyg.data.contract

import io.reactivex.Single
import jfyg.network.queries.ApiQuery

/**
 * Newly verified Contracts are synced to the API servers within 5 minutes or less
 * https://etherscan.io/apis#contracts
 */
class ContractABI : ContractABIContract {

    private val query = ApiQuery()
    private val abiQuery = query.contractABI("contract",
            "getabi",
            "0xBB9bc244D798123fDe783fCc1C72d3Bb8C189413")

    /**
     * Return contract ABI for Verified Contract Source Code
     */
    override fun getContractABI(address: String?): Single<String> = query.contractABI("contract",
            "getabi",
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