package jfyg.network

import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import jfyg.utils.Const
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
internal class RestClientTest {
    private var baseUrl: String = Const.BASE_URL
    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
    }

    @Test
    fun getQuery() {
        val fileName = """
                        {
                        "status": "1",
                        "message": "OK",
                        "result": "98658682905300000000000000"
                        }"""

        val gson = GsonBuilder()
                .setLenient()
                .create()

        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        mockWebServer.enqueue(MockResponse().setBody(fileName))

        val networkService: NetworkService = retrofit.create(NetworkService::class.java)

        val call = networkService.getStat("stats", "ethsupply", "")
        Assert.assertTrue(call.subscribe() != null)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

}