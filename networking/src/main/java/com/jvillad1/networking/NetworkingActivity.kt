package com.jvillad1.networking

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jvillad1.ccapcommons.sample.CommonsActivity
import com.jvillad1.networking.ui.theme.NetworkingTheme

class NetworkingActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetworkingTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    CallApi()
                }
            }
        }
    }
}

@Composable
fun CallApi() {
    Button(
        onClick = { context.startActivity(Intent(context, CommonsActivity::class.java)) }
    ) {
        Text(text = "Make Service Driven request")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NetworkingTheme {
        CallApi()
    }
}
