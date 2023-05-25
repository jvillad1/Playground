package com.jvillad1.playground

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.jvillad1.aliens.AliensActivity
import com.jvillad1.ccapcommons.sample.CommonsActivity
import com.jvillad1.congrats.CongratsActivity
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
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }

        PaymentEventHandler.subscribePaymentEvent(this) { paymentEvent ->
            when (paymentEvent) {
                is PerformPaymentEvent ->
                    Log.d(
                        "PaymentEventHandler",
                        "${paymentEvent.paymentData} PerformPaymentEvent"
                    )

                is PaymentResultEvent ->
                    Log.d(
                        "PaymentEventHandler",
                        "${paymentEvent.paymentResultData} PaymentResultEvent"
                    )
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { context.startActivity(Intent(context, CommonsActivity::class.java)) }
        ) {
            Text(text = "Navigate to Ccap Commons Library")
        }
        Button(
            onClick = { context.startActivity(Intent(context, CongratsActivity::class.java)) }
        ) {
            Text(text = "Navigate to Congrats Library")
        }
        Button(
            onClick = { context.startActivity(Intent(context, AliensActivity::class.java)) }
        ) {
            Text(text = "Navigate to Aliens Library")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    MyApplicationTheme {
        MainScreen()
    }
}
