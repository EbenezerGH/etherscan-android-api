package jfyg.data

import com.google.gson.annotations.SerializedName

data class ERC20Token(var blockNumber: String? = null,

                      var timeStamp: String? = null,

                      var hash: String? = null,

                      var nonce: String? = null,

                      var blockHash: String? = null,

                      @SerializedName("from")
                      var transactionFrom: String? = null,

                      var contractAddress: String? = null,

                      @SerializedName("to")
                      var transactionTo: String? = null,

                      var value: String? = null,

                      var tokenName: String? = null,

                      var tokenSymbol: String? = null,

                      var tokenDecimal: String? = null,

                      var transactionIndex: String? = null,

                      var gas: String? = null,

                      var gasPrice: String? = null,

                      var gasUsed: String? = null,

                      var cumulativeGasUsed: String? = null,

                      var input: String? = null,

                      var confirmations: String? = null)