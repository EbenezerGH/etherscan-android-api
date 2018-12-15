package jfyg.data

import com.google.gson.annotations.SerializedName

data class Tx(val blockNumber: String,

              val timeStamp: String,

              val hash: String,

              val nonce: String,

              val blockHash: String,

              val transactionIndex: String,

              @SerializedName("from")
              val transactionFrom: String,

              @SerializedName("to")
              val transactionTo: String,

              val value: String,

              val gas: String,

              val gasPrice: String,

              val isError: String,

              @SerializedName("txreceipt_status")
              val receiptStatus: String,

              val input: String,

              val contractAddress: String,

              val cumulativeGasUsed: String,

              val gasUsed: String,

              val confirmations: String)