package jfyg.contract

import io.reactivex.Single


internal interface SmartContractContract {

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