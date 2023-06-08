package com.jvillad1.networking.domain

import androidx.annotation.CheckResult
import com.jvillad1.ccapcommons.extensions.resultOf
import com.jvillad1.networking.data.ServiceDrivenResponse
import com.jvillad1.networking.ui.TypeError
import validateOrThrow
import javax.inject.Inject

class GetServiceDrivenMock @Inject constructor(
    private val serviceDrivenRepository: ServiceDrivenRepository
) {

    @CheckResult
    suspend operator fun invoke(): Result<ServiceDrivenResponse> = resultOf {
        val response = serviceDrivenRepository.getServiceDrivenMock()

        validateOrThrow(response.type?.isNotEmpty() == true) {
            TypeError("Type is empty or null, this is unexpected, needs to be handled")
        }

        response
    }
}
