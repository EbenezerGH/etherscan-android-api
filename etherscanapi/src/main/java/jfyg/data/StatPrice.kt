package jfyg.data

import com.squareup.moshi.Json

data class StatPrice(@field:Json(name = "ethbtc")
                     val ethBtc: String,

                     @field:Json(name = "ethbtc_timestamp")
                     val ethBtcTimestamp: String,

                     @field:Json(name = "ethusd")
                     val ethUsd: String,

                     @field:Json(name = "ethusd_timestamp")
                     val ethUsdTimestamp: String
)