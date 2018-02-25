package jfyg.etherscan.helloetherescan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jfyg.etherscan.helloetherescan.model.EtherPrice
import jfyg.etherscan.helloetherescan.network.RestClient

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.name!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        fab.setOnClickListener {
            queryPrice("1I7CRNU2QIU253UBPFVB5UV2C2PBDURAIY")
        }
    }

    private fun queryPrice(apiKey: String) {
        RestClient().getQuery()
                .getLastPrice(apiKey)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
    }

    private fun handleResponse(retrieveQuery: EtherPrice) {
        Log.d(TAG, "Eth in Btc: " + retrieveQuery.ethBtc)
        Log.d(TAG, "Eth in Btc Timestamp: " + retrieveQuery.ethBtcTimestamp)
        Log.d(TAG, "Eth in Usd: " + retrieveQuery.ethUsd)
        Log.d(TAG, "Eth in Usd Timestamp: " + retrieveQuery.ethUsdTimestamp)
        //Log.d(TAG, "Total Supply of Eth " + retrieveQuery.result)
    }

    private fun handleError(error: Throwable) {
        Log.d(TAG, "The error " + error.message)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
