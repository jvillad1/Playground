package com.jvillad1.networking.data

import retrofit2.Response
import retrofit2.http.GET

interface ServiceDrivenApi {

    @GET("https://run.mocky.io/v3/7ffba17d-1870-45cd-ab31-f0606f47dc09")
    suspend fun getServiceDrivenMock(): Response<ServiceDrivenResponse>
}
