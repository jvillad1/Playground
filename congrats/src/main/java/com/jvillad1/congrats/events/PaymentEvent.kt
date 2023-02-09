package com.jvillad1.congrats.events

sealed interface PaymentEvent

data class PerformPaymentEvent(
    val paymentData: String
) : PaymentEvent

data class PaymentResultEvent(
    val paymentResultData: String
) : PaymentEvent
