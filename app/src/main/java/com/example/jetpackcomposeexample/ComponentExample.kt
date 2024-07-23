package com.example.jetpackcomposeexample

import android.util.Log
import android.widget.CheckBox
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme


@Preview(showBackground = true)
@Composable
fun Preview() {
    JetpackComposeExampleTheme {
        MyRadioButtonList()
    }
}

@Composable
fun MyRadioButtonList() {
    var selected by rememberSaveable {
        mutableStateOf("Martin")
    }

    Column(Modifier.fillMaxSize()) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            RadioButton(selected = selected == "Martin", onClick = { selected = "Martin" })
            Text(text = "Martin")
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            RadioButton(selected = selected == "fulanito", onClick = { selected = "fulanito" })
            Text(text = "fulanito")
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            RadioButton(selected = selected == "grace", onClick = { selected = "grace" })
            Text(text = "grace")
        }
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            RadioButton(selected = selected == "pepito", onClick = { selected = "pepito" })
            Text(text = "pepito")
        }
    }

}

@Composable
fun MyTriStatusCheckBox(){
    var state by rememberSaveable {
        mutableStateOf(ToggleableState.Off)
    }

    TriStateCheckbox(state = state, onClick = {
        state = when (state){
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun MyCheckBox(){
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Row(Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center) {
        Checkbox(checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Yellow,
                checkmarkColor = Color.Cyan
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Seleccione esta opcion")
    }

}

@Composable
fun MySwitch(){
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Switch(checked = state, onCheckedChange = {state = !state}, enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Cyan,
            uncheckedTrackColor = Color.Magenta,
        )
    )
}

@Composable
fun MyProgressAdvance(){
    var progressStatus by rememberSaveable {
        mutableStateOf(0f)
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

            CircularProgressIndicator(progress = progressStatus, color = Color.Red, strokeWidth = 5.dp)
            LinearProgressIndicator(modifier = Modifier.padding(top = 32.dp), color = Color.Red, trackColor = Color.Green)


        Row(Modifier.fillMaxWidth()) {

        Button(onClick = {
            progressStatus += 0.1f
        }) {
            Text(text = "incrementa")
        }
            Button(onClick = {
                progressStatus -= 0.1f
            }) {
                Text(text = "reducir")
            }
        }
    }
}

@Composable
fun MyProgress(){
    var showLoading by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)) {
        if (showLoading){
            CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
            LinearProgressIndicator(modifier = Modifier.padding(top = 32.dp), color = Color.Red, trackColor = Color.Green)
        }

        Button(onClick = {showLoading = !showLoading}) {
            Text(text = "cargar perfil")
        }
    }
}

@Composable
fun MyIcon(){
    Icon(imageVector = Icons.Rounded.Star,
        contentDescription = "icon1",
        tint = Color.Red)
}

@Composable
fun MyImage(){
    Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Cyan, shape = CircleShape))
}


@Composable
fun MyButtonExample(){
    var enabled by rememberSaveable {
        mutableStateOf(true)
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)) {
        Button(onClick = {
            enabled = false
        }, colors = ButtonDefaults.buttonColors(
            contentColor = Color.Blue,
            containerColor = Color.Magenta),
            enabled = enabled,
            border = BorderStroke(5.dp, Color.Cyan)
        ) {
            Text(text = "hola")
        }

        OutlinedButton(onClick = {}) {
            Text(text = "hola")

        }
    }


}

@Composable
fun MyTextFieldOutLined(){
    var myText by remember {
        mutableStateOf("")
    }

    OutlinedTextField(value = myText, onValueChange = {myText = it}, modifier = Modifier.padding(24.dp), label = { Text(
        text = "Ingresa un texto"
    )
    }, colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = Color.Magenta,
        unfocusedTextColor = Color.Blue
    ),
        singleLine = true
    )
}

@Composable
fun MyTextFieldAdvance(modifier: Modifier = Modifier){
    var myText by remember {
        mutableStateOf("")
    }

    Box(modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        TextField(value = myText, onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        }, label = { Text(text = "Introduce tu nombre") })
    }
}


@Composable
fun MyTextField(modifier: Modifier = Modifier){
    var myText by remember {
        mutableStateOf("")
    }

    Box(modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        TextField(value = myText, onValueChange = {myText = it})
    }


}


@Composable
fun MyText(){
    Column(Modifier.fillMaxSize()) {
        Text(text = "esto es un ejemplo")
        Text(text = "esto es un ejemplo", color = Color.Red)
        Text(text = "esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text(text = "esto es un ejemplo", fontFamily = FontFamily.Cursive )
        Text(text = "esto es un ejemplo", textDecoration = TextDecoration.LineThrough)
        Text(text = "esto es un ejemplo", textDecoration = TextDecoration.combine(listOf(
            TextDecoration.Underline, TextDecoration.LineThrough)))
    }
}

@Composable
fun MyStateExample(){
    var counter by remember {
        mutableIntStateOf(0)
    }

    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Pulsar")
        }
        Text(text = "he sido pulsado $counter veces")

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
