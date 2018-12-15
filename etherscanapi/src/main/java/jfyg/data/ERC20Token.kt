package jfyg.data

import com.google.gson.annotations.SerializedName

data class ERC20Token(val blockNumber: String,

                      val timeStamp: String,

                      val hash: String,

                      val nonce: String,

                      val blockHash: String,

                      @SerializedName("from")
                      val transactionFrom: String,

                      val contractAddress: String,

                      @SerializedName("to")
                      val transactionTo: String,

                      val value: String,

                      val tokenName: String,

                      val tokenSymbol: String,

                      val tokenDecimal: String,

                      val transactionIndex: String,

                      val gas: String,

                      val gasPrice: String,

                      val gasUsed: String,

                      val cumulativeGasUsed: String,

                      val input: String,

                      val confirmations: String)