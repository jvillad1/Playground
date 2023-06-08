package com.jvillad1.networking.data

import com.jvillad1.ccapcommons.extensions.resultOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class ServiceDrivenRemoteDataSource @Inject constructor(
    private val serviceDrivenApi: ServiceDrivenApi
) {

    suspend fun getServiceDrivenMock(): Result<ServiceDrivenResponse> = resultOf {
        val response = withContext(Dispatchers.IO) {
            serviceDrivenApi.getServiceDrivenMock()
        }

        val body = response.body()

        if (response.isSuccessful && body != null) {
            body
        } else {
            Timber.d("The retrieved response is not successful and/or body is empty")
            error("The retrieved response is not successful and/or body is empty")
        }
    }
}
