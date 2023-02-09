package com.jvillad1.congrats.events

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

object PaymentEventHandler {

    fun publishPaymentEvent(lifecycleOwner: LifecycleOwner, paymentEvent: PaymentEvent) {
        lifecycleOwner.lifecycleScope.launch {
            EventBus.publish(paymentEvent)
        }
    }

    fun subscribePaymentEvent(lifecycleOwner: LifecycleOwner, onEvent: (PaymentEvent) -> Unit) {
        lifecycleOwner.lifecycleScope.launch {
            EventBus.subscribe<PaymentEvent> { paymentEvent ->
                onEvent(paymentEvent)
            }
        }
    }
}
