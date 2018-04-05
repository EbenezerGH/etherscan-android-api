package jfyg.response.account

import jfyg.model.Balances

/**
 * Balances of multiple accounts
 */
data class AccountMultiBalanceResponse(var result: ArrayList<Balances>? = null)