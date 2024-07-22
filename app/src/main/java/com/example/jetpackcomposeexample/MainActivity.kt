package com.example.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyBox(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MySpacer(size: Int){
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyComplexLayout(){
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center) {
            Text(text = "Ejmplo 1")
        }
        MySpacer(20)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)) {
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Red), contentAlignment = Alignment.Center) {
                Text(text = "Ejmplo 2")
            }
            Box(
                Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .background(Color.Green), contentAlignment = Alignment.Center) {
                Text(text = "Ejmplo 3")
            }
        }
        MySpacer(20)
        Box(
            Modifier
                .fillMaxSize()
                .weight(1f)
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter) {
            Text(text = "Ejmplo 4")
        }
    }
}

@Composable
fun MyRow(){
    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceAround) {
        Text(text = "ejemplo1", modifier = Modifier
            .background(Color.Red)
            .width(100.dp)
            .height(100.dp))
        Text(text = "ejemplo1", modifier = Modifier
            .background(Color.Red)
            .width(100.dp)
            .height(100.dp))
        Text(text = "ejemplo1", modifier = Modifier
            .background(Color.Red)
            .width(100.dp)
            .height(100.dp))
    }
}

@Composable
fun MyColumn(){
    Column(
        Modifier
            .fillMaxSize()
            , verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "ejemplo1", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "ejemplo2", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "ejemplo3", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(100.dp))
        Text(text = "ejemplo4", modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth()
            .height(100.dp))
    }
}

@Composable
fun MyBox(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Box(modifier = modifier
            .background(Color.Cyan)){
            Text(text = "hola mundo ")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeExampleTheme {
        MyComplexLayout()
    }
}