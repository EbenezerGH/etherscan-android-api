package jfyg.data.stat

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import jfyg.network.response.BaseResponse
import jfyg.network.response.StatPriceResponse
import jfyg.network.response.StatSupplyResponse
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

/**
 * https://etherscan.io/apis#stats
 */
internal class StatsApiTest {
    lateinit var gson: Gson

    private val inputSupply = """
        {
            "status": "1",
            "message": "OK",
            "result": "98658682905300000000000000"
        }"""

    private val inputBadResponse = """
        {
            "status": "0",
            "message": "NOTOK",
            "result": "Error!"
        }"""

    private val inputPrice = """
       {
            "status": "1",
            "message": "OK",
            "result": {
            "ethbtc": "0.0557",
            "ethbtc_timestamp": "1523064523",
            "ethusd": "377.67",
            "ethusd_timestamp": "1523064526"
            }
        }"""

    @Before
    fun setUp() {
        val gb = GsonBuilder()
        gson = gb.create()
    }

    @Test
    fun getTotalSupply() {
        val response = gson.fromJson(inputSupply, StatSupplyResponse::class.java)
        assertEquals("98658682905300000000000000", response.result)
    }

    @Test
    fun getTotalSupplyInWei() {
        val wei = 1000000000000000000 // 1 Ether is 1000000000000000000 Wei
        val response = gson.fromJson(inputSupply, StatSupplyResponse::class.java)
        assertEquals("9.86586829053E7", response.result?.toDouble()?.div(wei).toString())
    }

    @Test
    fun getEtherStatistics() {
        val response = gson.fromJson(inputPrice, StatPriceResponse::class.java)
        assertEquals("377.67", response.result.ethUsd)
        assertEquals("0.0557", response.result.ethBtc)
        assertEquals("1523064526", response.result.ethUsdTimestamp)
        assertEquals("1523064523", response.result.ethBtcTimestamp)

    }

    @Test
    fun networkStatusIsDown() {
        val response = gson.fromJson(inputBadResponse, BaseResponse::class.java)
        assertEquals("0", response.status)

    }

    @Test
    fun networkStatusIsUp() {
        val response = gson.fromJson(inputSupply, BaseResponse::class.java)
        assertEquals("1", response.status)
    }

    @Test
    fun networkMessageNotOk() {
        val response = gson.fromJson(inputBadResponse, BaseResponse::class.java)
        assertEquals("NOTOK", response.message)
    }

    @Test
    fun networkMessageOk() {
        val response = gson.fromJson(inputSupply, BaseResponse::class.java)
        assertEquals("OK", response.message)
    }

}