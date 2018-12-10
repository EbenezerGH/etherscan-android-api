package jfyg.data

import com.squareup.moshi.Json

data class TxsInternal(val blockNumber: String,

                       val timeStamp: String,

                       val hash: String,

                       @field:Json(name = "from")
                       val transactionFrom: String,

                       @field:Json(name = "to")
                       val transactionTo: String,

                       val value: String,

                       val contactAddress: String,

                       val input: String,

                       val type: String,

                       val gas: String,

                       val gasUsed: String,

                       val traceId: String,

                       val isError: String,

                       val errCode: String
)