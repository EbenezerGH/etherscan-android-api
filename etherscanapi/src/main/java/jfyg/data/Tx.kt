package jfyg.data

import com.google.gson.annotations.SerializedName

data class Tx(val blockNumber: String? = null,

              val timeStamp: String? = null,

              val hash: String? = null,

              val nonce: String? = null,

              val blockHash: String? = null,

              val transactionIndex: String? = null,

              @SerializedName("from")
              val transactionFrom: String? = null,

              @SerializedName("to")
              val transactionTo: String? = null,

              val value: String? = null,

              val gas: String? = null,

              val gasPrice: String? = null,

              val isError: String? = null,

              @SerializedName("txreceipt_status")
              val receiptStatus: String? = null,

              val input: String? = null,

              val contractAddress: String? = null,

              val cumulativeGasUsed: String? = null,

              val gasUsed: String? = null,

              val confirmations: String? = null)