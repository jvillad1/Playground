package com.jvillad1.networking.ui

import com.jvillad1.ccapcommons.base.UiState
import com.jvillad1.networking.data.ServiceDrivenResponse

data class ServiceDrivenUiState(
    val serviceDrivenResponse: ServiceDrivenResponse? = null,
    val serviceDrivenError: ServiceDrivenError? = null,
    val isLoading: Boolean = false
) : UiState

sealed interface ServiceDrivenError

// Business
data class TypeError(val errorMessage: String) : ServiceDrivenError, Exception(errorMessage)
