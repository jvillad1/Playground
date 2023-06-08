package com.jvillad1.networking.data

import com.jvillad1.networking.domain.ServiceDrivenRepository
import timber.log.Timber
import javax.inject.Inject

class ServiceDrivenRepositoryImpl @Inject constructor(
    private val serviceDrivenRemoteDataSource: ServiceDrivenRemoteDataSource
) : ServiceDrivenRepository {

    override suspend fun getServiceDrivenMock(): ServiceDrivenResponse =
        serviceDrivenRemoteDataSource.getServiceDrivenMock()
            .onSuccess { response ->
                Timber.d("Successful Service Driven response: ${response.content}")
            }
            .getOrThrow()
}
