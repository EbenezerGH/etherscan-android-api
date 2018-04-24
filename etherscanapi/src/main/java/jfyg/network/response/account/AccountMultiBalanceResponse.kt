package jfyg.network.response.account

import jfyg.data.Balances

/**
 * Balances of multiple accounts
 */
internal data class AccountMultiBalanceResponse(var result: ArrayList<Balances>? = null)