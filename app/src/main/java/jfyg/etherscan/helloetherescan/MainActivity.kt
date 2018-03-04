package jfyg.etherscan.helloetherescan

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import jfyg.etherscan.helloetherescan.ethereum.EthereumStat
import jfyg.etherscan.helloetherescan.model.EtherPriceModel
import jfyg.etherscan.helloetherescan.network.responses.MainResponse
import jfyg.etherscan.helloetherescan.network.RestClient

import kotlinx.android.synthetic.main.activity_main.*

//TODO: clean up and write tests
class MainActivity : AppCompatActivity() {
    private val TAG = javaClass.name!!

    var etherPrice = EtherPriceModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        //~~~ For Testing
        /*
        var testing = EthereumStat()
        fab.setOnClickListener {
            //testing.getTotalSupply()
            //testing.getTotalSupplyInWei()
            testing.getLastPriceInUsd()
            testing.getLastPriceInBtc()
            //queryStats("stats", "ethPrice")
        }
        */
    }

    fun queryStats(module: String, action: String) {
        RestClient().getQuery()
                .getEtherStats(module, action, ApiKey.takeOff.callApiKey())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError)
    }

    private fun handleResponse(retrieveQuery: MainResponse) {
        etherPrice.status = retrieveQuery.status
        etherPrice.message = retrieveQuery.message
        etherPrice.ethBtc = retrieveQuery.etherPriceresult?.ethBtc
        etherPrice.ethBtcTimestamp = retrieveQuery.etherPriceresult?.ethBtcTimestamp
        etherPrice.ethUsd = retrieveQuery.etherPriceresult?.ethUsd
        etherPrice.ethUsdTimestamp = retrieveQuery.etherPriceresult?.ethUsdTimestamp
    }

    private fun handleError(error: Throwable) {
        Log.d(TAG, "The error " + error.message)
    }

}