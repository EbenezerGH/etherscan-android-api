package jfyg.etherscan.helloetherescan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import jfyg.data.account.AccountsApi
import jfyg.data.block.BlocksApi
import jfyg.data.contract.ContractsApi
import jfyg.data.stat.StatsApi
import jfyg.data.transaction.TransactionsApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SampleActivity : AppCompatActivity() {
    private val TAG = javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //************************************************  Used To Test Singles returned from etherscanapi Module
        val stat = StatsApi()
        val account = AccountsApi()
        val contract = ContractsApi()
        val tx = TransactionsApi()
        val blocks = BlocksApi()

        fab.setOnClickListener {
            GlobalScope.launch {

                stat.getEtherStatistics()
                        .body()?.let { response ->
                            Log.d(TAG, "The Ether object has the values of: ${response.result}")
                        }

                stat.getEtherTotalSupply()
                        .body()?.let { response ->
                            Log.d(TAG, "The total supply of Ether is: ${response.result}")
                        }

                account.getMultiBalance(listOf(
                        "0xBB9bc244D798123fDe783fCc1C72d3Bb8C189413",
                        "0xBB9bc244D798123fDe783fCc1C72d3Bb8C189413",
                        "0x4e83362442b8d1bec281594cea3050c8eb01311c"))
                        .body()?.let { response ->
                            Log.d(TAG, "The current balance in account 0 is: ${response.result[0]}")
                            Log.d(TAG, "The current balance in account 1 is: ${response.result[1]}")
                            Log.d(TAG, "The current balance in account 2 is: ${response.result[2]}")
                        }


                account.getERC20Tokens("0x4e83362442b8d1bec281594cea3050c8eb01311c")
                        .body()?.let { response ->
                            Log.d(TAG, "ERC20 Token 1: ${response.result[0]}")
                            Log.d(TAG, "ERC20 Token 2: ${response.result[1]}")
                        }

                contract.getContractABI("0xBB9bc244D798123fDe783fCc1C72d3Bb8C189413")
                        .body()?.let { response ->
                            Log.d(TAG, "ABI of given contract: ${response.result}")
                        }

                tx.getTxExecutionStatus("0x15f8e5ea1079d9a0bb04a4c58ae5fe7654b5b2b4463375ff7ffb490aa0032f3a")
                        .body()?.let { response ->
                            Log.d(TAG,
                                    "The transaction's Error Status is: ${response.result.isError} and " +
                                            "transactions's error description is: ${response.result.errDescription}")
                        }

                blocks.getBlocksMined("2165403")
                        .body()?.let { response ->
                            Log.d(TAG, "The block miner is: ${response.result.blockMiner} and " +
                                    "uncles from this block: ${response.result.uncles}")
                        }
            }
        }
    }

}









