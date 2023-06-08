package com.jvillad1.ccapcommons.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface UiState

abstract class StatefulViewModel<STATE : UiState>(initialState: STATE) : ViewModel() {

    private val exceptionHandler = CoroutineExceptionHandler { context, throwable ->
        // 1. Trigger event to prompt error dialog
        // 2. Log to tracking system for observability
    }
    private val job = SupervisorJob()
    private val context = Dispatchers.Main + job + exceptionHandler

    protected val coroutineScope = CoroutineScope(context)

    protected val mutableUiState = MutableStateFlow(initialState)
    val uiState: StateFlow<STATE> = mutableUiState
}
