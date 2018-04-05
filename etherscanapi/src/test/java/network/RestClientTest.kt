package network

import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import jfyg.network.NetworkService
import junit.framework.Assert
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(JUnit4::class)
class RestClientTest {
    private var baseUrl: String = "http://api.etherscan.io/"
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
    }

    @Test
    @Throws(Exception::class)
    fun getQuery() {
        val fileName = "status_0_message_notok.json"

        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        mockWebServer.enqueue(MockResponse().setBody(fileName))

        var networkService: NetworkService = retrofit.create(NetworkService::class.java)

        val call = networkService.getStat("stats", "fail", "")
        Assert.assertTrue(call.subscribe() != null)
    }

    @After
    @Throws
    fun tearDown() {
        mockWebServer.shutdown()
    }

}