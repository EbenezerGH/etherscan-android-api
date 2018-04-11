package jfyg.account

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import jfyg.response.BaseResponse
import jfyg.response.account.AccountBalanceResponse
import jfyg.response.account.AccountMultiBalanceResponse
import org.junit.Assert.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AccountTest {

    val accountBalance = """
        {
"status": "1",
"message": "OK",
"result": "670456215218885498951364"
}"""

    val accountMultiBalance = """{
"status": "1",
"message": "OK",
"result": [
{
"account": "0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a",
"balance": "40807168564070000000000"
},
{
"account": "0x63a9975ba31b0b9626b34300f7f627147df1f526",
"balance": "332567136222827062478"
},
{
"account": "0x198ef1ec325a96cc354c7266a038be8b5c558f67",
"balance": "0"
}
]
}"""
    val accountTransactions = """{
"status": "1",
"message": "OK",
"result": [
{
"blockNumber": "5273167",
"timeStamp": "1521316197",
"hash": "0x308d39f4223154fdf2db3b803400dea0da7468592aded1c6e9c01fd35835f23f",
"nonce": "0",
"blockHash": "0x315ee5a947d4c7519bd817465711fbb0b56c8ecafc8d9766aef1350e83c41521",
"transactionIndex": "28",
"from": "0x047250bd5ac59e6c45473cc0036d71737c885f6a",
"to": "0x82e4499d4b2a669831a3881d61bb24f7b620c61a",
"value": "18034800000000000",
"gas": "21000",
"gasPrice": "4000000000",
"isError": "0",
"txreceipt_status": "1",
"input": "0x",
"contractAddress": "",
"cumulativeGasUsed": "1376343",
"gasUsed": "21000",
"confirmations": "150836"
},
{
"blockNumber": "5273704",
"timeStamp": "1521323646",
"hash": "0x55a6922f90f0fce43896b9b2239ddddd3f829fb06291724bfb4be6fcc895d202",
"nonce": "0",
"blockHash": "0xeb96c9b68ae66c42dbf35f323e66534858d88dd1b107f77bb2c65504140e9752",
"transactionIndex": "14",
"from": "0x4a7341f16107521adca5d24009e7c2d8829787d3",
"to": "0x82e4499d4b2a669831a3881d61bb24f7b620c61a",
"value": "53297010000000000",
"gas": "21000",
"gasPrice": "4000000000",
"isError": "0",
"txreceipt_status": "1",
"input": "0x",
"contractAddress": "",
"cumulativeGasUsed": "391843",
"gasUsed": "21000",
"confirmations": "150299"
}
]
}"""
    val accountBlocksMined = """{
"status": "1",
"message": "OK",
"result": [
{
"blockNumber": "3462296",
"timeStamp": "1491118514",
"blockReward": "5194770940000000000"
},
{
"blockNumber": "2691400",
"timeStamp": "1480072029",
"blockReward": "5086562212310617100"
},
{
"blockNumber": "70606",
"timeStamp": "1439322608",
"blockReward": "5001164799033398000"
}
]
}"""

    val inputBadResponse = """
        {
            "status": "0",
            "message": "NOTOK",
            "result": "Error!"
        }"""


    lateinit var gson: Gson


    @Before
    fun setUp() {
        val gb = GsonBuilder()
        gson = gb.create()
    }


    @Test
    fun getBalance() {
        val response = gson.fromJson(accountBalance, AccountBalanceResponse::class.java)
        assertEquals("670456215218885498951364", response.result)
    }

    @Test
    fun getMultiBalance() {
        val response = gson.fromJson(accountMultiBalance, AccountMultiBalanceResponse::class.java)
        assertEquals("3",response.result?.size)
        assertEquals("3",response.result)
    }

    @Test
    fun getBlocks() {
    }

    @Test
    fun getTransactions() {
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