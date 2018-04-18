package jfyg.model

import com.google.gson.annotations.SerializedName

data class Txs(var blockNumber: String? = null,

               var timeStamp: String? = null,

               var hash: String? = null,

               var nonce: String? = null,

               var blockHash: String? = null,

               var transactionIndex: String? = null,

               @SerializedName("from")
                        var transactionFrom: String? = null,

               @SerializedName("to")
                        var transactionTo: String? = null,

               var value: String? = null,

               var gas: String? = null,

               var gasPrice: String? = null,

               var isError: String? = null,

               @SerializedName("txreceipt_status")
                        var receiptStatus: String? = null,

               var input: String? = null,

               var contractAddress: String? = null,

               var cumulativeGasUsed: String? = null,

               var gasUsed: String? = null,

               var confirmations: String? = null)