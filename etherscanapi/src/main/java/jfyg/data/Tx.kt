package jfyg.data

import com.squareup.moshi.Json

data class Tx(val blockNumber: String,

              val timeStamp: String,

              val hash: String,

              val nonce: String,

              val blockHash: String,

              val transactionIndex: String,

              @field:Json(name = "from")
              val transactionFrom: String,

              @field:Json(name = "to")
              val transactionTo: String,

              val value: String,

              val gas: String,

              val gasPrice: String,

              val isError: String,

              @field:Json(name = "txreceipt_status")
              val receiptStatus: String,

              val input: String,

              val contractAddress: String,

              val cumulativeGasUsed: String,

              val gasUsed: String,

              val confirmations: String
)