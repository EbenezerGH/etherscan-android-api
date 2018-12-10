package jfyg.network.queries

import jfyg.ApiKey
import jfyg.network.RestClient
import jfyg.network.response.AccountBalanceResponse
import jfyg.network.response.AccountBlockResponse
import jfyg.network.response.ERC20Response
import jfyg.network.response.AccountInternalTxResponse
import jfyg.network.response.AccountMultiBalanceResponse
import jfyg.network.response.AccountTxResponse
import jfyg.network.response.BlockResponse
import jfyg.network.response.ContractResponse
import jfyg.network.response.StatPriceResponse
import jfyg.network.response.StatSupplyResponse
import jfyg.network.response.TxContractExecutionResponse
import jfyg.network.response.TxContractReceiptResponse
import retrofit2.Response

/**
 * A mediator between the responses and errors that come from every query
 */
internal class ApiQuery : AccountsApi, StatsApi, ContractsApi, TransactionsApi, BlocksApi {

    override suspend fun accountBalance(module: String,
                                        action: String,
                                        address: String,
                                        tag: String): Response<AccountBalanceResponse> =
            RestClient().getQuery().getAccountBalance(module, action, address, tag, ApiKey.takeOff.callApiKey()).await()

    override suspend fun accountMultiBalance(module: String,
                                             action: String,
                                             address: String,
                                             tag: String?): Response<AccountMultiBalanceResponse> =
            RestClient().getQuery().getAccountMultiBalance(module, action, address, tag, ApiKey.takeOff.callApiKey()).await()

    override suspend fun accountBlock(module: String,
                                      action: String,
                                      address: String,
                                      blocktype: String): Response<AccountBlockResponse> =
            RestClient().getQuery().getAccountBlock(module, action, address, blocktype, ApiKey.takeOff.callApiKey()).await()

    override suspend fun accountTxs(module: String,
                                    action: String,
                                    address: String,
                                    startblock: String,
                                    endblock: String,
                                    sort: String): Response<AccountTxResponse> =
            RestClient().getQuery().getAccountTransactions(module, action, address, startblock, endblock, sort, ApiKey.takeOff.callApiKey()).await()

    override suspend fun accountERC20Txs(module: String,
                                         action: String,
                                         address: String,
                                         startblock: String,
                                         endblock: String,
                                         sort: String): Response<ERC20Response> =
            RestClient().getQuery().getAccountERC20Transactions(module, action, address, startblock, endblock, sort, ApiKey.takeOff.callApiKey()).await()

    override suspend fun accountInternalTxs(module: String,
                                            action: String,
                                            address: String,
                                            startblock: String,
                                            endblock: String,
                                            sort: String): Response<AccountInternalTxResponse> =
            RestClient().getQuery().getAccountInternalTransactions(module, action, address, startblock, endblock, sort, ApiKey.takeOff.callApiKey()).await()

    override suspend fun contractABI(module: String,
                                     action: String,
                                     address: String): Response<ContractResponse> =
            RestClient().getQuery().getSmartContract(module, action, address, ApiKey.takeOff.callApiKey()).await()

    override suspend fun statPrice(module: String,
                                   action: String): Response<StatPriceResponse> =
            RestClient().getQuery().getStat(module, action, ApiKey.takeOff.callApiKey()).await()


    override suspend fun statSupply(module: String,
                                    action: String): Response<StatSupplyResponse> =
            RestClient().getQuery().getStatSupply(module, action, ApiKey.takeOff.callApiKey()).await()

    override suspend fun txExecutionStatus(module: String,
                                           action: String,
                                           txHash: String): Response<TxContractExecutionResponse> =
            RestClient().getQuery().getContractTransactionExecution(module, action, txHash, ApiKey.takeOff.callApiKey()).await()

    override suspend fun txReceiptStatus(module: String,
                                         action: String,
                                         txHash: String): Response<TxContractReceiptResponse> =
            RestClient().getQuery().getContractTransactionReceipt(module, action, txHash, ApiKey.takeOff.callApiKey()).await()

    override suspend fun blocksMined(module: String,
                                     action: String,
                                     blockno: String): Response<BlockResponse> =
            RestClient().getQuery().getBlocksMined(module, action, blockno, ApiKey.takeOff.callApiKey()).await()

}