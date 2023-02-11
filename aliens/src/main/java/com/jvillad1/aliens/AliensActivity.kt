package com.jvillad1.aliens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jvillad1.aliens.ui.theme.AliensTheme

class AliensActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AliensTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    AndroidAliens()
                }
            }
        }
    }
}

@Composable
fun AndroidAlien(
    color: Color,
    modifier: Modifier = Modifier,
) {
    Image(
        modifier = modifier,
        painter = painterResource(R.drawable.android_alien),
        colorFilter = ColorFilter.tint(color = color),
        contentDescription = null
    )
}

@Composable
fun AndroidAliensRow(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Top,
    ) {
        AndroidAlien(
            color = Color.Red,
            modifier = Modifier
                .size(70.dp)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.Green,
            modifier = Modifier
                .fillMaxSize()
                .weight(1F)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.Blue,
            modifier = Modifier
                .size(70.dp)
                .align(Alignment.CenterVertically)
                .padding(4.dp)
        )
    }
}

@Composable
fun AndroidAliensColumn(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AndroidAlien(
            color = Color.Red,
            modifier = Modifier
                .size(70.dp)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.Green,
            modifier = Modifier
                .size(70.dp)
                .padding(4.dp)
        )
        AndroidAlien(
            color = Color.Blue,
            modifier = Modifier
                .size(70.dp)
                .padding(4.dp)
        )
    }
}

@Composable
fun AndroidAliens() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidAliensRow(Modifier.weight(1F))
        AndroidAliensColumn(Modifier.weight(1F))
    }
}

@Preview(showBackground = true)
@Composable
fun AndroidAliensPreview() {
    AliensTheme {
        AndroidAliens()
    }
}
