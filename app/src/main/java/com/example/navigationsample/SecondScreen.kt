@file:Suppress("UNUSED_EXPRESSION")

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(
    sharedViewModel: SharedViewModel,
    navigationToFirstScreen: () -> Unit,
    navigationToThirdScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "İkinci Ekran", fontSize = 24.sp)
        Text(text = "Hoşgeldin, ${sharedViewModel.name}", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = sharedViewModel.name,
            onValueChange = { sharedViewModel.updateName(it) },
            label = { Text("isim") },
            placeholder = { Text("isim giriniz") }
        )
        Row {
            NavigationButton("İlk Ekrana Git", navigationToFirstScreen)
            NavigationButton("Üçüncü Ekrana Git", navigationToThirdScreen)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    val sharedViewModel = SharedViewModel()
    sharedViewModel.updateName("Örnek İsim")
    SecondScreen(
        sharedViewModel = sharedViewModel,
        navigationToFirstScreen = {},
        navigationToThirdScreen = {}
    )
}
