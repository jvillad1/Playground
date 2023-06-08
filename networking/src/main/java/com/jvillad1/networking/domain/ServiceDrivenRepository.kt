package com.jvillad1.networking.domain

import com.jvillad1.networking.data.ServiceDrivenResponse

interface ServiceDrivenRepository {

    suspend fun getServiceDrivenMock(): ServiceDrivenResponse
}
