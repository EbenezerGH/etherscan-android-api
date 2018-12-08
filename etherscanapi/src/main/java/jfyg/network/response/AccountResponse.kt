package jfyg.network.response

import jfyg.data.*

/**
 * Balance of Ether existing in an account
 */
internal data class AccountBalanceResponse(val result: String? = null) : BaseResponse()

/**
 * Blocks mined by an account
 */
internal data class AccountBlockResponse(val result: List<BlockAccount>? = null) : BaseResponse()

/**
 * Internal Transactions recorded by an account
 */
internal class AccountInternalTxResponse(val result: List<TxsInternal>? = null) : BaseResponse()

/**
 * Balances of multiple accounts
 */
internal data class AccountMultiBalanceResponse(val result: List<Balance>? = null)

/**
 * Transactions recorded by an account
 */
internal data class AccountTxResponse(val result: List<Tx>? = null) : BaseResponse()

/**
 * ERC20 Transactions recorded by an account
 */
internal class ERC20Response(val result: List<ERC20Token>? = null) : BaseResponse()