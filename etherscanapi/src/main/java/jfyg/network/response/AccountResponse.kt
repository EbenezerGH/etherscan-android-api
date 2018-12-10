package jfyg.network.response

import jfyg.data.*

/**
 * Balance of Ether existing in an account
 */
data class AccountBalanceResponse(val result: String) : BaseResponse()

/**
 * Blocks mined by an account
 */
data class AccountBlockResponse(val result: List<BlockAccount>) : BaseResponse()

/**
 * Internal Transactions recorded by an account
 */
class AccountInternalTxResponse(val result: List<TxsInternal>) : BaseResponse()

/**
 * Balances of multiple accounts
 */
data class AccountMultiBalanceResponse(val result: List<Balance>): BaseResponse()

/**
 * Transactions recorded by an account
 */
data class AccountTxResponse(val result: List<Tx>) : BaseResponse()

/**
 * ERC20 Transactions recorded by an account
 */
class ERC20Response(val result: List<ERC20Token>) : BaseResponse()