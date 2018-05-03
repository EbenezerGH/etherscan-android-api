package jfyg.data

import com.google.gson.annotations.SerializedName

data class ERC20Token(val blockNumber: String? = null,

                      val timeStamp: String? = null,

                      val hash: String? = null,

                      val nonce: String? = null,

                      val blockHash: String? = null,

                      @SerializedName("from")
                      val transactionFrom: String? = null,

                      val contractAddress: String? = null,

                      @SerializedName("to")
                      val transactionTo: String? = null,

                      val value: String? = null,

                      val tokenName: String? = null,

                      val tokenSymbol: String? = null,

                      val tokenDecimal: String? = null,

                      val transactionIndex: String? = null,

                      val gas: String? = null,

                      val gasPrice: String? = null,

                      val gasUsed: String? = null,

                      val cumulativeGasUsed: String? = null,

                      val input: String? = null,

                      val confirmations: String? = null)