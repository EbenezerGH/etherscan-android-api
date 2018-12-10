package jfyg.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import jfyg.utils.BASE_URL
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Client used to create the network call
 */
internal class RestClient {

    private val networkService: NetworkService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

        networkService = retrofit.create(NetworkService::class.java)
    }

    fun getQuery(): NetworkService {
        return networkService
    }

}