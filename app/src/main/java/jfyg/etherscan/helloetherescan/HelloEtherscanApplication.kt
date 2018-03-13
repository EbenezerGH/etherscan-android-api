package jfyg.etherscan.helloetherescan

import android.app.Application
import jfyg.etherscanapi.ApiKey

class HelloEtherscanApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ApiKey.takeOff.setApiKey("1I7CRNU2QIU253UBPFVB5UV2C2PBDURAIYZ")
    }
}