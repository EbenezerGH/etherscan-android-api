package jfyg.data.contract

import io.reactivex.Single

/**
 * Newly verified Contracts are synced to the API servers within 5 minutes or less
 * https://etherscan.io/apis#contracts
 */
internal interface ContractABIContract {

    /**
     * Return contract ABI for Verified Contract Source Code
     */
    fun getContractABI(address: String?): Single<String>

    /**
     * Return network status
     */
    fun getNetworkStatus(): Single<String>

    /**
     * Return network message
     */
    fun getNetworkMessage(): Single<String>
}