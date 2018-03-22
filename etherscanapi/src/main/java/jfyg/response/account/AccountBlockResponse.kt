package jfyg.response.account

import jfyg.model.Blocks
import jfyg.response.BaseResponse

/**
 * Blocks mined by an account
 */
class AccountBlockResponse : BaseResponse() {

    var result: ArrayList<Blocks>? = null

}
