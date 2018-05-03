[![Generic badge](https://img.shields.io/badge/EtherscanApi-UP-brightgreen.svg)](https://api.etherscan.io/api?module=stats&action=ethprice&apikey=YourApiKeyToken)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/EbenezerGH/hello_etherscan/blob/update-documentation/LICENSE)
[![CircleCI](https://circleci.com/gh/EbenezerGH/hello_etherscan/tree/master.svg?style=svg)](https://circleci.com/gh/EbenezerGH/hello_etherscan/tree/master)


# etherscan-android-api

etherscan android api is an android wrapper for the [etherscan api](https://etherscan.io/apis).  This is just a module to handle networking calls.

No Releases yet, [features](https://github.com/EbenezerGH/hello_etherscan/issues) still left to be completed.

## Getting Started

import a reactive android library to handle the reactive stream being passed into your module.


    implementation 'io.reactivex.rxjava2:rxandroid:x.y.z'
    implementation 'io.reactivex.rxjava2:rxkotlin:x.y.z'


Optional: Call `ApiKey.takeOff.setApiKey("[your api key here]")` in module's application class when recording api usage in the etherscan.io console. [see [example implementation](https://github.com/EbenezerGH/hello_etherscan/blob/master/app/src/main/java/jfyg/etherscan/helloetherescan/HelloEtherscanApplication.kt)]
```
ApiKey.takeOff.setApiKey("1I7CRNU2QIU253UBPFVB5UV2C2PBDURAIYZ")
```

Create an Instance of one of the reactive Singles and access values by specifying thread and subscribing. [see [example implementation](https://github.com/EbenezerGH/hello_etherscan/blob/master/app/src/main/java/jfyg/etherscan/helloetherescan/MainActivity.kt)]

Currently Available: ``[accounts, contracts, transactions, blocks, stat]``

Coming Soon: ``[eventLogs, geth, websockets, tokens]``

```
        val stat = Stat()
        val account = Account()
        val contract = ContractABI()
        val tx = TxStatus()
        val blocks = BlocksMined()

            //account test
            account.getERC20Tokens("0x4e83362442b8d1bec281594cea3050c8eb01311c")
                    .observeOn(AndroidSchedulers.mainThread())
                    ?.subscribeBy(
                            onSuccess = { Log.d(TAG, "The Account Size of Transactions is: ${it.size}") },
                            onError = { Log.d(TAG, "error receiving ERC20") })

            //contracts test
            contract.getContractABI("0xBB9bc244D798123fDe783fCc1C72d3Bb8C189413")
                    .observeOn(AndroidSchedulers.mainThread())
                    ?.subscribeBy(
                            onSuccess = { Log.d(TAG, "The ABI has returned: $it") },
                            onError = { Log.d(TAG, "error receiving abi contract") })



            //blocks test
            blocks.getBlocksMined("2165403")
                    .observeOn(AndroidSchedulers.mainThread())
                    ?.subscribeBy(
                            onSuccess = {
                                Log.d(TAG, "The block miner is: ${it.blockMiner} and " +
                                        "the first miner : ${it.uncles?.get(0)?.miner}")
                            },
                            onError = { Log.d(TAG, "error receiving blocks mined") })
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

## References

[**Etherscan APIs**](https://etherscan.io/apis)

[**Contracts Verified**](https://etherscan.io/contractsVerified)

[**Ethereum Github Repo**](https://github.com/ethereum)

[**Ethereum Wiki**](https://github.com/ethereum/wiki/wiki/JSON-RPC)


