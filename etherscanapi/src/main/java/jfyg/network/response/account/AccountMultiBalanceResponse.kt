package jfyg.network.response.account

import jfyg.data.Balance

/**
 * Balances of multiple accounts
 */
internal data class AccountMultiBalanceResponse(val result: List<Balance>? = null)