package jfyg.data

import com.google.gson.annotations.SerializedName

data class TxsInternal(val blockNumber: String? = null,

                       val timeStamp: String? = null,

                       val hash: String? = null,

                       @SerializedName("from")
                       val transactionFrom: String? = null,

                       @SerializedName("to")
                       val transactionTo: String? = null,

                       val value: String? = null,

                       val contactAddress: String? = null,

                       val input: String? = null,

                       val type: String? = null,

                       val gas: String? = null,

                       val gasUsed: String? = null,

                       val traceId: String? = null,

                       val isError: String? = null,

                       val errCode: String? = null)