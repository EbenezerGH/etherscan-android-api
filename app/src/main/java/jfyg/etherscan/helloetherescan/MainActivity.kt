package jfyg.etherscan.helloetherescan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import jfyg.account.Account
import jfyg.contract.SmartContract
import jfyg.stat.Stat
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
        val contract = SmartContract()


        fab.setOnClickListener {

            //stat test
            stat.getLastPriceInBtc().observeOn(AndroidSchedulers.mainThread())
                    ?.subscribeBy {
                        Log.d(TAG, "The current price of Ether in Btc: $it")
                    }

            //account test
            account.getTransactions("0x2c1ba59d6f58433fb1eaee7d20b26ed83bda51a3").observeOn(AndroidSchedulers.mainThread())
                    ?.subscribeBy {
                        Log.d(TAG, "The Account Size of Transactions is: ${it.size}")
                    }

            //contracts test
            contract.getContractABI("0xBB9bc244D798123fDe783fCc1C72d3Bb8C189413").observeOn(AndroidSchedulers.mainThread())
                    ?.subscribeBy {
                        Log.d(TAG, "The EBI has returned: $it")
                    }

            //transaction test
        }
    }

}
