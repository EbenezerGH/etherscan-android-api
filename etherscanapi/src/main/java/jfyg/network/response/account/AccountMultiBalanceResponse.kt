package jfyg.network.response.account

import jfyg.data.Balance

/**
 * Balances of multiple accounts
 */
internal data class AccountMultiBalanceResponse(var result: List<Balance>? = null)