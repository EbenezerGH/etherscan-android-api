package jfyg.contract

import io.reactivex.Single
import jfyg.queries.QueryMediator

class SmartContract : SmartContractContract {
    private val query = QueryMediator()
    private val abiQuery = query.abiContract("contract",
            "getabi",
            "0xBB9bc244D798123fDe783fCc1C72d3Bb8C189413")

    override fun getContractABI(address: String?): Single<String> = query.abiContract("contract",
            "getabi",
            address).map { it.result }

    override fun getNetworkStatus(): Single<String> = abiQuery.map { it.status }

    override fun getNetworkMessage(): Single<String> = abiQuery.map { it.message }

}