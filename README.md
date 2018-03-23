# hello_etherscan

hello_etherscan is just a wrapper for the [Etherscan Api](https://etherscan.io/apis).  There are many different network calls and it may be best to just abstract out this huge bulk of code into a module or library.

## Getting Started

This library is still in beta and not ready for it's first release, there are still a few more [issues](https://github.com/EbenezerGH/hello_etherscan/issues) to complete.

To use this project as a module:

Clone project or download
```
https://github.com/EbenezerGH/hello_etherscan.git
```

In your app directory's gradle, import the module
```
implementation project(':etherscanapi')
```
In your root directory's settings.gradle be sure to add the module into your include right after your previous module seperated by a comma [Example Implementation](https://github.com/EbenezerGH/hello_etherscan/blob/master/settings.gradle)
```
':etherscanapi'
```

Call `ApiKey.takeOff.setApiKey("[your api key here]")` if recording api usage in the etherscan.io console [see [Example implementation](https://github.com/EbenezerGH/hello_etherscan/blob/master/app/src/main/java/jfyg/etherscan/helloetherescan/HelloEtherscanApplication.kt)]
```
ApiKey.takeOff.setApiKey("1I7CRNU2QIU253UBPFVB5UV2C2PBDURAIYZ")
```

Lastly call the given function that's needed by creating an instance of one of the Etherscan Apis [accounts, contracts, transactions, blocks, eventLogs, geth, websockets, tokens, [stat](https://etherscan.io/apis#stats)]

```
//stat
Log.d(TAG, "The total supply of Ether:  ${stat.getTotalSupply()}")
Log.d(TAG, "The total supply of Ether in Wei:  ${stat.getTotalSupplyInWei()}")

//account
Log.d(TAG, "The Account Status is: ${account.getNetworkStatus()}")
Log.d(TAG, "The Account Message is: ${account.getNetworkMessage()}")
```
```
jfyg.etherscan.helloetherescan D/jfyg.etherscan.helloetherescan.MainActivity: The current price of Ether in Usd:  533.22
jfyg.etherscan.helloetherescan D/jfyg.etherscan.helloetherescan.MainActivity: The total supply of Ether:  9.83557402803E25
jfyg.etherscan.helloetherescan D/jfyg.etherscan.helloetherescan.MainActivity: The total supply of Ether in Wei:  9.835574028029999E7
jfyg.etherscan.helloetherescan D/jfyg.etherscan.helloetherescan.MainActivity: The Account Status is: 1
jfyg.etherscan.helloetherescan D/jfyg.etherscan.helloetherescan.MainActivity: The Account Message is: OK
```

## Authors

* [**Ebenezer Ackon**](http://www.ebenezerackon.com/)

```
BTC: 1MLaf31sjVG3LbMyQEuY16qosPAhwNRQeZ
ETH: 82e4499D4b2A669831a3881d61BB24f7b620c61a
LTC: La1vhdzuVY85EEW8m5hTpw4C15gPY9hVDW
```

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
