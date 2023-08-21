package com.coffee.kmpapi.utils

object ApisUrls {
    private const val versionV4 =  "v4"
    private const val versionV3 =  "v3"
    const val EndUrlV4 = "https://api.spacexdata.com/$versionV4/"
    const val EndUrlV3 = "https://api.spacexdata.com/$versionV3/"

}


sealed class KmpResponse<out T> {
    object Loading : KmpResponse<Nothing>()
    data class Success<T>(val data: T) : KmpResponse<T>()
    data class Error(val exception: Exception) : KmpResponse<Nothing>()
}