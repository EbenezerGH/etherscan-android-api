package jfyg.transaction

import io.reactivex.Single
import jfyg.model.TxExecutionStatus
import jfyg.model.TxReceiptStatus
import jfyg.queries.QueryMediator


class TransactionContractStatus : TransactionContract {
    private val query = QueryMediator()
    private val genericNetworkQuery = query.transactionContractReceiptStatus("transaction",
            "getstatus",
            "0x15f8e5ea1079d9a0bb04a4c58ae5fe7654b5b2b4463375ff7ffb490aa0032f3a")


    override fun getTransactionExecutionStatus(txHash: String): Single<TxExecutionStatus> =
            query.transactionContractExecutionStatus("transaction",
                    "getstatus",
                    txHash).map { it.result }

    override fun getTransactionReceiptStatus(txHash: String): Single<TxReceiptStatus> =
            query.transactionContractReceiptStatus("transaction",
                    "gettxreceiptstatus",
                    txHash).map { it.result }

    override fun getNetworkStatus(): Single<String> = genericNetworkQuery.map { it.status }

    override fun getNetworkMessage(): Single<String> = genericNetworkQuery.map { it.message }


}