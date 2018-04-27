package jfyg.utils

/**
 * Utilities that may be used to provide successful Queries
 */
internal object QueryUtils {
    /**
     * Retrieve a list of mulitple items
     */
    fun retrieveList(listItems: List<String>?): String {

        var getList = ""

        for (item in listItems!!) {
            getList += item + ","
        }

        return getList.dropLast(1)
    }
}