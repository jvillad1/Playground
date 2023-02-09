package com.jvillad1.congrats.events

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class PaymentEventHandler {

    suspend fun postPaymentEvent(paymentEvent: PaymentEvent) {
        EventBus.publish(paymentEvent)
    }

    fun subscribePaymentEvent(lifecycleOwner: LifecycleOwner) {
        lifecycleOwner.lifecycleScope.launch {
            EventBus.subscribe<PaymentEvent> { paymentEvent ->
                when (paymentEvent) {
                    is PerformPaymentEvent ->
                        Log.d("PaymentEventHandler", "${paymentEvent.paymentData} PerformPaymentEvent")

                    is PaymentResultEvent ->
                        Log.d("PaymentEventHandler", "${paymentEvent.paymentResultData} PaymentResultEvent")
                }
            }
        }
    }
}
