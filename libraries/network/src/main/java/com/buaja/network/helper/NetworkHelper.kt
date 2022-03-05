package com.buaja.network.helper

import com.buaja.network.utils.ApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


/**
 * @created 05/03/22 14.01
 * @author Julsapargi Nursam
 * @project Fishery
 **/

fun <T> safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): Flow<ApiResult<T>> {
    return flow<ApiResult<T>> {
        emit(ApiResult.Success(apiCall.invoke()))
    }.catch { throwable ->
        emit(ApiResult.Error(throwable))
    }.flowOn(dispatcher)
}