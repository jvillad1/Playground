package com.jvillad1.congrats

import android.os.Bundle
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
import com.jvillad1.congrats.ui.theme.CongratsTheme

class MainActivity2 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CongratsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PaymentEventScreen(
                        onPerformPaymentEvent = {
                            PaymentEventHandler.publishPaymentEvent(
                                this,
                                PerformPaymentEvent(paymentData = "Payment Data")
                            )
                        }
                    ) {
                        PaymentEventHandler.publishPaymentEvent(
                            this,
                            PaymentResultEvent(paymentResultData = "Payment result Data")
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PaymentEventScreen(
    onPerformPaymentEvent: () -> Unit = {},
    onPaymentResultEvent: () -> Unit = {}
) {
    Column {
        Row {
            Button(
                onClick = onPerformPaymentEvent
            ) {
                Text(text = "Publish PerformPaymentEvent")
            }
        }
        Row {
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
    CongratsTheme {
        PaymentEventScreen()
    }
}
