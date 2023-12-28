package com.hira.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hira.news.custom_component.CustomTextField
import com.hira.news.ui.theme.NewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  installSplashScreen()
        setContent {
            NewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    mainComposer()
                }
            }
        }
    }
}

@Composable
fun mainComposer() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        customText(message = "This is slider Dem", fontSize = 30f)
        Spacer(modifier = Modifier.height(150.dp))
        customSlider()
        var text by remember { mutableStateOf("") }
        CustomTextField(
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text("User Name") },
            placeholder = { Text("Placeholder") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { /* Handle Done action here */ }
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        customText(message = text, fontSize =30f )
    }


}

@Composable
fun customText(message: String, fontSize: Float) {
    Text(
        text = message,
        fontSize = fontSize.sp,
        style = MaterialTheme.typography.headlineLarge
    )
}
@Composable
fun customTextField(){
    var (textValue,setText)= remember {
        mutableStateOf("")
    }
    val onTextChange={text:String->setText(text)}
    TextField(value = textValue, onValueChange =onTextChange )
}
@Composable
fun customSlider() {
    var sliderPosition by remember {
        mutableStateOf(20f)
    }
    val handlePosionChange = { posion: Float -> sliderPosition = posion }
    Slider(
        modifier = Modifier.padding(10.dp),
        value = sliderPosition,
        onValueChange = { handlePosionChange(it) },
        valueRange = 20f..40f
    )
    customText(message = "${sliderPosition}sp", fontSize = 30f)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsTheme {
        mainComposer()
    }
}
