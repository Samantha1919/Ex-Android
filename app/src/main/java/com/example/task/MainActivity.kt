package com.example.task
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task.ui.theme.TaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface (
                        modifier = Modifier.padding(innerPadding).fillMaxSize(),
                    ) {
                        Information(
                            title = "All tasks completed",
                            subtitle = "Nice work",
                            modifier = Modifier.padding(innerPadding)
                        )

                    }
                }
            }
        }
    }
}



@Composable
fun Information(title: String, subtitle: String, modifier: Modifier = Modifier) {
    Column( verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier.fillMaxSize()) {
        val image = painterResource(R.drawable.check)
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        Text(
            text = title,
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = Bold,
            textAlign = TextAlign.Center, // se centre mtn que jai mis le v et h A sur la Column
            )
        Text(
            text = subtitle,
            modifier = modifier,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskTheme {
        Information("Android", subtitle = "hello")
    }
}