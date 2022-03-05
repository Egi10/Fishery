package com.buaja.network.utils


/**
 * @created 05/03/22 14.02
 * @author Julsapargi Nursam
 * @project Fishery
 **/

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val throwable: Throwable) : ApiResult<Nothing>()
}
