[![Generic badge](https://img.shields.io/badge/EtherscanApi-UP-brightgreen.svg)](https://api.etherscan.io/api?module=stats&action=ethprice&apikey=YourApiKeyToken)
[![Generic badge](https://img.shields.io/badge/Version-v2.0.0-lightgrey.svg)](https://jitpack.io/#EbenezerGH/etherscan-android-api)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/EbenezerGH/hello_etherscan/blob/update-documentation/LICENSE)

# etherscan-android-api

etherscan android api is an android wrapper for the [etherscan api](https://etherscan.io/apis).  This is just a module to handle networking calls.

There are only a few [features](https://github.com/EbenezerGH/hello_etherscan/issues) left to add, however version 2.0.0+ is completely safe to use.

## Getting Started

Add JitPack to your root build.gradle at the end of repositories
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```


Add the dependency


```
	dependencies {
	        implementation 'com.github.EbenezerGH:etherscan-android-api:v2.0.0'
	}
```


Optional: Call `ApiKey.takeOff.setApiKey("[your api key here]")` in your module's application class when recording api usage in the etherscan.io console. [see [example implementation](https://github.com/EbenezerGH/etherscan-android-api/blob/master/etherscan-sample/src/main/java/jfyg/etherscan/helloetherescan/EtherscanSampleApplication.kt)]
```
ApiKey.takeOff.setApiKey("1I7CRNU2QIU253UBPFVB5UV2C2PBDURAIYZ")
```

Instantiate an Api Instance and handle the response [see [example implementation](https://github.com/EbenezerGH/etherscan-android-api/blob/master/etherscan-sample/src/main/java/jfyg/etherscan/helloetherescan/SampleActivity.kt)]

Currently Available: ``[accountsApi, contractsApi, transactionsApi, blocksApi, statApi]``

Coming Soon: ``[eventLogs, geth, websockets, tokens]``

## Authors

* [**Ebenezer Ackon**](http://www.ebenezerackon.com/)

```
BTC: 1MLaf31sjVG3LbMyQEuY16qosPAhwNRQeZ
ETH: 82e4499D4b2A669831a3881d61BB24f7b620c61a
LTC: LUF9RpzZ3kyKMYpSNiAT5hx7qR3q7ShV3H
```

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

## References

[**Etherscan APIs**](https://etherscan.io/apis)

[**Contracts Verified**](https://etherscan.io/contractsVerified)

[**Ethereum Github Repo**](https://github.com/ethereum)

[**Ethereum Wiki**](https://github.com/ethereum/wiki/wiki/JSON-RPC)


