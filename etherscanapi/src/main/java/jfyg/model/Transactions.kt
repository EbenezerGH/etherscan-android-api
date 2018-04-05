package jfyg.model

import com.google.gson.annotations.SerializedName

data class Transactions(var blockNumber: String? = null,

                        var timeStamp: String? = null,

                        var hash: String? = null,

                        @SerializedName("from")
                        var transactionFrom: String? = null,

                        @SerializedName("to")
                        var transactionTo: String? = null,

                        var value: String? = null,

                        var contractAddress: String? = null,

                        var input: String? = null,

                        var type: String? = null, var gas: String? = null,

                        var gasUsed: String? = null,

                        var traceId: String? = null,

                        var isError: String? = null,

                        var errCode: String? = null)