package jfyg.utils

import org.junit.Assert
import org.junit.Test

class QueryUtilsTest {

    @Test
    fun retrieveAccounts() {
        var getAccounts = ""
        val accounts = ArrayList<String>()
        accounts.add("0x82e4499D4b2A669831a3881d61BB24f7b620c61a")
        accounts.add("0x63a9975ba31b0b9626b34300f7f627147df1f526")
        accounts.add("0x198ef1ec325a96cc354c7266a038be8b5c558f67")

        for (addresses in accounts) {
            getAccounts += addresses + ","
        }

        Assert.assertEquals("0x82e4499D4b2A669831a3881d61BB24f7b620c61a," +
                "0x63a9975ba31b0b9626b34300f7f627147df1f526," +
                "0x198ef1ec325a96cc354c7266a038be8b5c558f67",
                getAccounts.dropLast(1))
    }

}