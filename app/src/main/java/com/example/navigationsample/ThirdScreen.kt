package com.example.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ThirdScreen(sharedViewModel: SharedViewModel,
                navigationToFirstScreen: () -> Unit,
                navigationToSecondScreen: () -> Unit){
    val name= remember{
        mutableStateOf(sharedViewModel.name)
    }
    Column(
        modifier =Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "ucuncu ekran", fontSize = 24.sp)
        Text(text = "hoşgeldin ${name.value}", fontSize = 20.sp)
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text("isim") },
            placeholder = { Text("isim giriniz") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            //fonks. çağıracağız
            NavigationButton("ilk ekran", navigationToFirstScreen)
            NavigationButton("ikinci ekran", navigationToSecondScreen)
        }
    }
}
@Preview
@Composable
fun ThirdScreenPreview(){
    val sharedViewModel = SharedViewModel()
    sharedViewModel.updateName("Örnek İsim")
    ThirdScreen(
        sharedViewModel = sharedViewModel,
        navigationToFirstScreen = {},
        navigationToSecondScreen = {}
    )
}