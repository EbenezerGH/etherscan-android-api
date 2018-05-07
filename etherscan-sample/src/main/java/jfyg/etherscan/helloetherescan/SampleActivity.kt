package jfyg.etherscan.helloetherescan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import jfyg.data.account.Accounts
import jfyg.data.block.Blocks
import jfyg.data.contract.Contracts
import jfyg.data.stat.Stats
import jfyg.data.transaction.Transactions
import kotlinx.android.synthetic.main.activity_main.*


class SampleActivity : AppCompatActivity() {
    private val TAG = javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //************************************************  Used To Test Singles returned from etherscanapi Module
        val stat = Stats()
        val account = Accounts()
        val contract = Contracts()
        val tx = Transactions()
        val blocks = Blocks()


        fab.setOnClickListener {

            //stat test
            stat.getLastPriceInBtc()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onSuccess = { Log.d(TAG, "The current price of Ether in Btc: $it") },
                            onError = { Log.d(TAG, "error receiving stat") })


            //account test
            account.getERC20Tokens("0x4e83362442b8d1bec281594cea3050c8eb01311c")
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onSuccess = { Log.d(TAG, "The Account Size of Transactions is: ${it.size}") },
                            onError = { Log.d(TAG, "error receiving ERC20") })

            //contracts test
            contract.getContractABI("0xBB9bc244D798123fDe783fCc1C72d3Bb8C189413")
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onSuccess = { Log.d(TAG, "The ABI has returned: $it") },
                            onError = { Log.d(TAG, "error receiving abi contract") })

            //transaction test
            tx.getTxExecutionStatus("0x15f8e5ea1079d9a0bb04a4c58ae5fe7654b5b2b4463375ff7ffb490aa0032f3a")
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onSuccess = {
                                Log.d(TAG, "The transaction's Error Status is: ${it.isError} and " +
                                        "transactions's error description is: ${it.errDescription}")
                            },
                            onError = { Log.d(TAG, "error receiving tx status") })

            //blocks test
            blocks.getBlocksMined("2165403")
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeBy(
                            onSuccess = {
                                Log.d(TAG, "The block miner is: ${it.blockMiner} and " +
                                        "the first miner : ${it.uncles[0].miner}")
                            },
                            onError = { Log.d(TAG, "error receiving blocks mined") })
        }
    }

}
