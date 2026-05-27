package com.example.myapplication

import android.R.attr.description
import android.R.attr.name
import android.R.attr.text
import android.accessibilityservice.GestureDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold( modifier = Modifier.fillMaxSize() ) { innerPadding ->
                    Informations(
                        title = "Android",
                        description = "test",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Informations(title: String, description: String, backgroundColor : Color = Color.Cyan, modifier: Modifier = Modifier) { // on met une valeur par defaut comme ca il met pas derreur, Modifier cest la valeur par defaut et dcp par defaut on initliase un truc vide
    Column(modifier = modifier.background(backgroundColor)) {
        Text(
            text = title,
            modifier = Modifier
        )
        Text(
            text = description,
            modifier = Modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Informations(
            title = "Android",
            description = "test",
        )
    }
}