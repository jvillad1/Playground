package com.jvillad1.networking.ui

import com.jvillad1.ccapcommons.base.StatefulViewModel
import com.jvillad1.networking.domain.GetServiceDrivenMock
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ServiceDrivenViewModel @Inject constructor(
    private val getServiceDrivenMock: GetServiceDrivenMock
) : StatefulViewModel<ServiceDrivenUiState>(ServiceDrivenUiState()) {

    private var fetchJob: Job? = null

    fun getServiceDrivenMock() {
        fetchJob?.cancel()
        // TODO: Review / Test the scope created in the StatefulViewModel
        fetchJob = coroutineScope.launch {
            showLoading()

            getServiceDrivenMock.invoke()
                .onSuccess { response ->
                    Timber.d("Response has content: ${response.content} ")
                    mutableUiState.update { currentUiState ->
                        currentUiState.copy(
                            serviceDrivenResponse = response,
                            isLoading = false
                        )
                    }
                }
                .onFailure { throwable ->
                    Timber.wtf(throwable, "Error thrown and needs to be handled on the UI")
                    handleServiceDrivenError(throwable)
                }
        }
    }

    private fun showLoading() {
        mutableUiState.update { currentUiState ->
            currentUiState.copy(isLoading = true)
        }
    }

    private fun handleServiceDrivenError(throwable: Throwable) {
        (throwable as? ServiceDrivenError)?.let { error ->
            mutableUiState.update { currentUiState ->
                currentUiState.copy(
                    isLoading = false,
                    serviceDrivenError = error
                )
            }
        }
    }

    fun serviceDrivenErrorHandled() {
        mutableUiState.update { currentUiState ->
            currentUiState.copy(serviceDrivenError = null)
        }
    }
}
