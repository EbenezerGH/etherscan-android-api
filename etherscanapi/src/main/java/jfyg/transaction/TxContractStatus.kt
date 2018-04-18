package jfyg.transaction

import io.reactivex.Single
import jfyg.model.TxExecutionStatus
import jfyg.model.TxReceiptStatus
import jfyg.queries.QueryMediator

/**
 * https://etherscan.io/apis#transactions
 */
class TxContractStatus : TxContract {

    private val query = QueryMediator()
    private val genericNetworkQuery = query.txReceiptStatus("transaction",
            "getstatus",
            "0x15f8e5ea1079d9a0bb04a4c58ae5fe7654b5b2b4463375ff7ffb490aa0032f3a")

    /**
     * [BETA] Check Contract Execution Status (if there was an error during contract execution)
     * Note: isError":"0" = Pass , isError":"1" = Error during Contract Execution
     */
    override fun getTxExecutionStatus(txHash: String): Single<TxExecutionStatus> =
            query.txExecutionStatus("transaction",
                    "getstatus",
                    txHash).map { it.result }

    /**
     * [BETA] Check Transaction Receipt Status (Only applicable for Post Byzantium fork transactions)
     * Note: status: 0 = Fail, 1 = Pass. Will return null/empty value for pre-byzantium fork
     */
    override fun getTxReceiptStatus(txHash: String): Single<TxReceiptStatus> =
            query.txReceiptStatus("transaction",
                    "gettxreceiptstatus",
                    txHash).map { it.result }

    /**
     * Return network status
     */
    override fun getNetworkStatus(): Single<String> = genericNetworkQuery.map { it.status }

    /**
     * Return network message
     */
    override fun getNetworkMessage(): Single<String> = genericNetworkQuery.map { it.message }

}