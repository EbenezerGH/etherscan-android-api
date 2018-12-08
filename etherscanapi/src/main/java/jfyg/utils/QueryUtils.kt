package jfyg.utils

/**
 * Retrieve a list of mulitple items
 */
internal fun retrieveList(listItems: List<String>?): String {

    var getList = ""

    for (item in listItems!!) {
        getList += "$item,"
    }

    return getList.dropLast(1)
}
