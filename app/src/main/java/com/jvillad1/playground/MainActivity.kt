package com.jvillad1.playground

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jvillad1.congrats.events.PaymentEventHandler
import com.jvillad1.congrats.events.PaymentResultEvent
import com.jvillad1.congrats.events.PerformPaymentEvent
import com.jvillad1.playground.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting(
                        name = "Android",
                        onPerformPaymentEvent = {
                            PaymentEventHandler.publishPaymentEvent(
                                this,
                                PerformPaymentEvent(paymentData = "Payment Data")
                            )
                        },
                        onPaymentResultEvent = {
                            PaymentEventHandler.publishPaymentEvent(
                                this,
                                PaymentResultEvent(paymentResultData = "Payment result Data")
                            )
                        }
                    )
                }
            }
        }

        PaymentEventHandler.subscribePaymentEvent(this) { paymentEvent ->
            when (paymentEvent) {
                is PerformPaymentEvent ->
                    Log.d("PaymentEventHandler", "${paymentEvent.paymentData} PerformPaymentEvent")

                is PaymentResultEvent ->
                    Log.d("PaymentEventHandler", "${paymentEvent.paymentResultData} PaymentResultEvent")
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    onPerformPaymentEvent: () -> Unit = {},
    onPaymentResultEvent: () -> Unit = {}
) {
    Column() {
        Row() {
            Button(
                onClick = onPerformPaymentEvent
            ) {
                Text(text = "Publish PerformPaymentEvent")
            }
        }
        Row() {
            Button(
                onClick = onPaymentResultEvent
            ) {
                Text(text = "Publish PaymentResultEvent")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}
