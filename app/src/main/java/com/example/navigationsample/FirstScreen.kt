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
fun FirstScreen(
    sharedViewModel: SharedViewModel,
    navigationToSecondScreen: () -> Unit,
    navigationToThirdScreen: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "İlk Ekran", fontSize = 24.sp)
        OutlinedTextField(
            value = sharedViewModel.name,
            onValueChange = { sharedViewModel.updateName(it) },
            label = { Text("İsim") },
            placeholder = { Text("İsim giriniz") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            NavigationButton("İkinci Ekrana Git", navigationToSecondScreen)
            NavigationButton("Üçüncü Ekrana Git", navigationToThirdScreen)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    val sharedViewModel = SharedViewModel()
    sharedViewModel.updateName("Örnek İsim")
    FirstScreen(
        sharedViewModel = sharedViewModel,
        navigationToSecondScreen = {},
        navigationToThirdScreen = {}
    )
}
