package jfyg.etherscan.helloetherescan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import jfyg.data.account.Account
import jfyg.data.contract.ContractABI
import jfyg.data.stat.Stat
import jfyg.data.transaction.TxStatus
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //************************************************  Used To Test Singles returned from etherscanapi Module
        val stat = Stat()
        val account = Account()
        val contract = ContractABI()
        val tx = TxStatus()


        fab.setOnClickListener {

            //stat test
            stat.getLastPriceInBtc()
                    .observeOn(AndroidSchedulers.mainThread())
                    ?.subscribeBy {
                        Log.d(TAG, "The current price of Ether in Btc: $it")
                    }

            //account test
            account.getERC20Tokens("0x4e83362442b8d1bec281594cea3050c8eb01311c")
                    .observeOn(AndroidSchedulers.mainThread())
                    ?.subscribeBy {
                        Log.d(TAG, "The Account Size of Transactions is: ${it.size}")
                    }

            //contracts test
            contract.getContractABI("0xBB9bc244D798123fDe783fCc1C72d3Bb8C189413")
                    .observeOn(AndroidSchedulers.mainThread())
                    ?.subscribeBy {
                        Log.d(TAG, "The ABI has returned: $it")
                    }

            //transaction test
            tx.getTxExecutionStatus("0x15f8e5ea1079d9a0bb04a4c58ae5fe7654b5b2b4463375ff7ffb490aa0032f3a")
                    .observeOn(AndroidSchedulers.mainThread())
                    ?.subscribeBy {
                        Log.d(TAG, "The transaction's Error Status is: ${it.isError} and " +
                                "transactions's error description is: ${it.errDescription}")
                    }
        }
    }

}
