package jfyg.etherscan.helloetherescan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import jfyg.stat.EthereumStat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val stat = EthereumStat()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            Log.d("Ebenezer", stat.getLastPriceInBtc())
        }
    }

}