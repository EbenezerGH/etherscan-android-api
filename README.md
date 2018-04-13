# hello_etherscan

hello_etherscan is a wrapper for the [Etherscan Api](https://etherscan.io/apis).  This is just a module to handle Networking calls.

## Getting Started
No Releases yet, [issues](https://github.com/EbenezerGH/hello_etherscan/issues) to complete.

Call `ApiKey.takeOff.setApiKey("[your api key here]")` if recording api usage in the etherscan.io console [see [Example implementation](https://github.com/EbenezerGH/hello_etherscan/blob/master/app/src/main/java/jfyg/etherscan/helloetherescan/HelloEtherscanApplication.kt)]
```
ApiKey.takeOff.setApiKey("1I7CRNU2QIU253UBPFVB5UV2C2PBDURAIYZ")
```

Create an Instance of one of the following and access values [see [Example implementation](https://github.com/EbenezerGH/hello_etherscan/blob/master/app/src/main/java/jfyg/etherscan/helloetherescan/MainActivity.kt)]

``[accounts, contracts, transactions, blocks, eventLogs, geth, websockets, tokens, stat]``

```
val stat = Stat()
val account = Account()
"The current price of Ether in Usd:  ${stat.getLastPriceInUsd()}"
"The Account Balance is: ${account.getBalance("0x82e4499D4b2A669831a3881d61BB24f7b620c61a")}"
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
