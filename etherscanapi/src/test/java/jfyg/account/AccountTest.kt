package jfyg.account

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import jfyg.response.BaseResponse
import jfyg.response.account.AccountBalanceResponse
import jfyg.response.account.AccountBlockResponse
import jfyg.response.account.AccountInternalTxResponse
import jfyg.response.account.AccountMultiBalanceResponse
import jfyg.response.account.AccountTxResponse
import org.junit.Assert.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * https://etherscan.io/apis#accounts
 */
internal class AccountTest {
    lateinit var gson: Gson

    private val accountBalance = """
        {
            "status": "1",
            "message": "OK",
            "result": "670456215218885498951364"
        }"""

    private val accountMultiBalance = """
        {
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
    private val accountBlocksMined = """
        {
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

    private val accountTxs = """
        {
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

    private val internalTxs = """
        {
            "status": "1",
            "message": "OK",
            "result": [
            {
            "blockNumber": "2535368",
            "timeStamp": "1477837690",
            "hash": "0x8a1a9989bda84f80143181a68bc137ecefa64d0d4ebde45dd94fc0cf49e70cb6",
            "from": "0x20d42f2e99a421147acf198d775395cac2e8b03d",
            "to": "",
            "value": "0",
            "contractAddress": "0x2c1ba59d6f58433fb1eaee7d20b26ed83bda51a3",
            "input": "",
            "type": "create",
            "gas": "254791",
            "gasUsed": "46750",
            "traceId": "0",
            "isError": "0",
            "errCode": ""
            },
            {
            "blockNumber": "2535479",
            "timeStamp": "1477839134",
            "hash": "0x1a50f1dc0bc912745f7d09b988669f71d199719e2fb7592c2074ede9578032d0",
            "from": "0x2c1ba59d6f58433fb1eaee7d20b26ed83bda51a3",
            "to": "0x20d42f2e99a421147acf198d775395cac2e8b03d",
            "value": "100000000000000000",
            "contractAddress": "",
            "input": "",
            "type": "call",
            "gas": "235231",
            "gasUsed": "0",
            "traceId": "0",
            "isError": "0",
            "errCode": ""
            }
            ]
        }"""
    private val inputBadResponse = """
        {
            "status": "0",
            "message": "NOTOK",
            "result": "Error!"
        }"""


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
        assertEquals("0xddbd2b932c763ba5b1b7ae3b362eac3e8d40121a", response.result?.get(0)?.account)
        assertEquals("40807168564070000000000", response.result?.get(0)?.balance)
        assertEquals("0x63a9975ba31b0b9626b34300f7f627147df1f526", response.result?.get(1)?.account)
        assertEquals("332567136222827062478", response.result?.get(1)?.balance)
        assertEquals("0x198ef1ec325a96cc354c7266a038be8b5c558f67", response.result?.get(2)?.account)
        assertEquals("0", response.result?.get(2)?.balance)
    }

    @Test
    fun getBlocks() {
        val response = gson.fromJson(accountBlocksMined, AccountBlockResponse::class.java)
        assertEquals("3462296", response.result?.get(0)?.blockNumber)
        assertEquals("1491118514", response.result?.get(0)?.timeStamp)
        assertEquals("5194770940000000000", response.result?.get(0)?.blockReward)
        assertEquals("2691400", response.result?.get(1)?.blockNumber)
        assertEquals("1480072029", response.result?.get(1)?.timeStamp)
        assertEquals("5086562212310617100", response.result?.get(1)?.blockReward)
    }

    @Test
    fun getTransactions() {
        val response = gson.fromJson(accountTxs, AccountTxResponse::class.java)
        assertEquals("0x047250bd5ac59e6c45473cc0036d71737c885f6a", response.result?.get(0)?.transactionFrom)
        assertEquals("0x82e4499d4b2a669831a3881d61bb24f7b620c61a", response.result?.get(0)?.transactionTo)
        assertEquals("18034800000000000", response.result?.get(0)?.value)
        assertEquals("21000", response.result?.get(1)?.gas)
        assertEquals("4000000000", response.result?.get(1)?.gasPrice)
        assertEquals("0", response.result?.get(1)?.isError)
    }

    @Test
    fun getInternalTransactions() {
        val response = gson.fromJson(internalTxs, AccountInternalTxResponse::class.java)
        assertEquals("0x20d42f2e99a421147acf198d775395cac2e8b03d", response.result?.get(0)?.transactionFrom)
        assertEquals("0x20d42f2e99a421147acf198d775395cac2e8b03d", response.result?.get(1)?.transactionTo)
        assertEquals("0", response.result?.get(0)?.value)
        assertEquals("235231", response.result?.get(1)?.gas)
        assertEquals("call", response.result?.get(1)?.type)
        assertEquals("0", response.result?.get(1)?.isError)
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