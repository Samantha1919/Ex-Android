package com.example.task

import android.os.Build.VERSION.SDK_INT
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
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
        if (SDK_INT >= 29) window.isNavigationBarContrastEnforced = false
        setContent {
            TaskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Information(
                        title = "test", subtitle = "nice work",
                         modifier = EmptyModifier.padding(innerPadding) // on apllique juste a modifier tu faisais ca avant mais la tu dois juste preciser le nom vu quon a aps mis dimage, ca applique juste innerPadding quon met en param depuis le scaffold
                    )
                }
            }
        }
    }
}

val EmptyModifier = Modifier // pr preciser que cest une instance vide

//class Test()
//
//val a = Test()
//val b = Test()
//
//val Modifer = Modifier()

//fun add1(nb1: Int): Int {
////    return nb1 + 1
//    return add10(number = nb1)
//}
//
//fun add10(number: Int): Int {
//    return number + 10
//}
//
//fun main() {
//    add1(nb1 = 5)
//    add10(number = 5)
//}

@Composable
fun Information(
    title: String = "defaut",
    subtitle: String,
    image: Painter = painterResource(R.drawable.check),
    modifier: Modifier = EmptyModifier,
) { // image tu peux le renommer, jai mis une valeur par defaut a image // la Modifier cest une instance vide
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize() // ca prend toute la place sur lecran,  sapllique sur tt mais apres et en prenant compte de lordre dans lequel tas definir tes modif sur ton Modifier
    ) {

        Image(
            painter = image, // image tu peux le renommer
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        Text(
            text = title,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = Bold,
            textAlign = TextAlign.Center, // se centre mtn que jai mis le v et h A sur la Column
        )
        Text(
            text = subtitle,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    TaskTheme {
        Information(subtitle = "hello", image = painterResource(R.drawable.chat))
    }
}

@Preview(showBackground = true)
@Composable
fun Preview2() {
    TaskTheme {
        Information(title = "test", subtitle = "nice work")
    }
}