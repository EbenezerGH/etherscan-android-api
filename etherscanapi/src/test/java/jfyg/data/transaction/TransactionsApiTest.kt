package jfyg.data.transaction

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import jfyg.network.response.BaseResponse
import jfyg.network.response.TxContractExecutionResponse
import jfyg.network.response.TxContractReceiptResponse
import org.junit.Assert
import org.junit.Test

import org.junit.Before

/**
 * https://etherscan.io/apis#transactions
 */
class TransactionsApiTest {
    lateinit var gson: Gson

    private val inputBadResponse = """
        {
            "status": "0",
            "message": "NOTOK",
            "result": "Error!"
        }"""

    private val txExecutionStatus = """
        {
            "status": "1",
            "message": "OK",
            "result": {
            "isError": "1",
            "errDescription": "Bad jump destination"
        }}"""

    private val txReceiptStatus = """
        {
            "status": "1",
            "message": "OK",
            "result": {
            "status": "1"
        }}"""

    @Before
    fun setUp() {
        val gb = GsonBuilder()
        gson = gb.create()
    }

    @Test
    fun getTxExecutionStatus() {
        val response = gson.fromJson(txExecutionStatus, TxContractExecutionResponse::class.java)
        Assert.assertEquals("1", response.result.isError)
        Assert.assertEquals("Bad jump destination", response.result.errDescription)

    }

    @Test
    fun getTxReceiptStatus() {
        val response = gson.fromJson(txReceiptStatus, TxContractReceiptResponse::class.java)
        Assert.assertEquals("1", response.result.status)
    }

    @Test
    fun networkStatusIsDown() {
        val response = gson.fromJson(inputBadResponse, BaseResponse::class.java)
        Assert.assertEquals("0", response.status)
    }

    @Test
    fun networkStatusIsUp() {
        val response = gson.fromJson(inputBadResponse, BaseResponse::class.java)
        Assert.assertNotEquals("1", response.status)
    }

    @Test
    fun networkMessageNotOk() {
        val response = gson.fromJson(inputBadResponse, BaseResponse::class.java)
        Assert.assertEquals("NOTOK", response.message)
    }

    @Test
    fun networkMessageOk() {
        val response = gson.fromJson(inputBadResponse, BaseResponse::class.java)
        Assert.assertNotEquals("OK", response.message)
    }
}