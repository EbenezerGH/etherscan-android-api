package jfyg.network.queries

import io.reactivex.Single
import jfyg.ApiKey
import jfyg.network.RestClient
import jfyg.network.response.account.AccountBalanceResponse
import jfyg.network.response.account.AccountBlockResponse
import jfyg.network.response.account.ERC20Response
import jfyg.network.response.account.AccountInternalTxResponse
import jfyg.network.response.account.AccountMultiBalanceResponse
import jfyg.network.response.account.AccountTxResponse
import jfyg.network.response.block.BlockResponse
import jfyg.network.response.contract.ContractResponse
import jfyg.network.response.stat.StatPriceResponse
import jfyg.network.response.stat.StatSupplyResponse
import jfyg.network.response.transaction.TxContractExecutionResponse
import jfyg.network.response.transaction.TxContractReceiptResponse

/**
 * A mediator between the responses and errors that come from every query
 */
internal class ApiQuery : AccountsApi, StatsApi, ContractsApi, TransactionsApi, BlocksApi {


    override fun accountBalance(module: String?,
                                action: String?,
                                address: String?,
                                tag: String?): Single<AccountBalanceResponse> =
            RestClient().getQuery().getAccountBalance(module, action, address, tag, ApiKey.takeOff.callApiKey())

    override fun accountMultiBalance(module: String?,
                                     action: String?,
                                     address: String?,
                                     tag: String?): Single<AccountMultiBalanceResponse> =
            RestClient().getQuery().getAccountMultiBalance(module, action, address, tag, ApiKey.takeOff.callApiKey())

    override fun accountBlock(module: String?,
                              action: String?,
                              address: String?,
                              blocktype: String?): Single<AccountBlockResponse> =
            RestClient().getQuery().getAccountBlock(module, action, address, blocktype, ApiKey.takeOff.callApiKey())

    override fun accountTxs(module: String?,
                            action: String?,
                            address: String?,
                            startblock: String?,
                            endblock: String?,
                            sort: String?): Single<AccountTxResponse> =
            RestClient().getQuery().getAccountTransactions(module, action, address, startblock, endblock, sort, ApiKey.takeOff.callApiKey())

    override fun accountERC20Txs(module: String?,
                                 action: String?,
                                 address: String?,
                                 startblock: String?,
                                 endblock: String?,
                                 sort: String?): Single<ERC20Response> =
            RestClient().getQuery().getAccountERC20Transactions(module, action, address, startblock, endblock, sort, ApiKey.takeOff.callApiKey())

    override fun accountInternalTxs(module: String?,
                                    action: String?,
                                    address: String?,
                                    startblock: String?,
                                    endblock: String?,
                                    sort: String?): Single<AccountInternalTxResponse> =
            RestClient().getQuery().getAccountInternalTransactions(module, action, address, startblock, endblock, sort, ApiKey.takeOff.callApiKey())

    override fun contractABI(module: String?, action: String?, address: String?): Single<ContractResponse> =
            RestClient().getQuery().getSmartContract(module, action, address, ApiKey.takeOff.callApiKey())

    override fun statPrice(module: String,
                           action: String): Single<StatPriceResponse> =
            RestClient().getQuery().getStat(module, action, ApiKey.takeOff.callApiKey())


    override fun statSupply(module: String,
                            action: String): Single<StatSupplyResponse> =
            RestClient().getQuery().getStatSupply(module, action, ApiKey.takeOff.callApiKey())

    override fun txExecutionStatus(module: String?,
                                   action: String?,
                                   txHash: String?): Single<TxContractExecutionResponse> =
            RestClient().getQuery().getContractTransactionExecution(module, action, txHash, ApiKey.takeOff.callApiKey())

    override fun txReceiptStatus(module: String?,
                                 action: String?,
                                 txHash: String?): Single<TxContractReceiptResponse> =
            RestClient().getQuery().getContractTransactionReceipt(module, action, txHash, ApiKey.takeOff.callApiKey())

    override fun blocksMined(module: String?,
                             action: String?,
                             blockno: String?): Single<BlockResponse> =
            RestClient().getQuery().getBlocksMined(module, action, blockno, ApiKey.takeOff.callApiKey())

}