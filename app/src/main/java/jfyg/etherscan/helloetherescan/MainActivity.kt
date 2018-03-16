package jfyg.etherscan.helloetherescan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import jfyg.stat.Stat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //************************************************  Used To Test Library
        val stat = Stat() //TODO #29

        fab.setOnClickListener {

            Log.d(TAG, "The Status is ${stat.getNetworkStatus()}")
            Log.d(TAG, "The Message is ${stat.getNetworkMessage()}")
            Log.d(TAG, "The current price of Ether in Btc:  ${stat.getLastPriceInBtc()}")
            Log.d(TAG, "Timestamp price in Btc:  ${stat.getBtcTimestamp()}")
            Log.d(TAG, "Timestamp price in Ether:  ${stat.getEthTimestamp()}")
            Log.d(TAG, "The current price of Ether in Usd:  ${stat.getLastPriceInUsd()}")
            Log.d(TAG, "The total supply of Ether:  ${stat.getTotalSupply()}")
            Log.d(TAG, "The total supply of Ether in Wei:  ${stat.getTotalSupplyInWei()}")

        }
    }


}