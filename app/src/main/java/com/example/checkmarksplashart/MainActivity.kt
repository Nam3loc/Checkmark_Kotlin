package com.example.checkmarksplashart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.checkmarksplashart.ui.theme.CheckmarkSplashArtTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheckmarkSplashArtTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CheckmarkImage()
                }
            }
        }
    }
}

@Composable
fun CheckmarkImage() {
    val image = painterResource(R.drawable.ic_task_completed)
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier
    ) {
        Column {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )
            CheckmarkText(
                taskCompletionText = stringResource(R.string.tasks),
                message = stringResource(R.string.congrats),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun CheckmarkText(taskCompletionText: String, message: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = taskCompletionText,
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = 24.dp,
                    bottom = 8.dp
                )
        )
        Text(
        text = message,
        fontSize = 18.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckmarkPreview() {
    CheckmarkSplashArtTheme {
        CheckmarkImage()
    }
}