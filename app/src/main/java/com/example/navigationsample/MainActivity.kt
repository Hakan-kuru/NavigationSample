package com.example.navigationsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigationsample.ui.theme.NavigationSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigationSampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    enableEdgeToEdge() // Edge-to-edge desteği
                    setContent {
                        NavigationSampleTheme {
                            Surface(
                                modifier = Modifier.fillMaxSize(),
                                color = MaterialTheme.colorScheme.background
                            ) {
                                val sharedViewModel: SharedViewModel = viewModel()
                                MyApp(sharedViewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun MyApp(sharedViewModel: SharedViewModel ){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "firstScreen"){

        composable("firstScreen"){
            FirstScreen(
                sharedViewModel = sharedViewModel,
                navigationToSecondScreen = { navController.navigate("secondScreen") },
                navigationToThirdScreen = { navController.navigate("thirdScreen") }
            )
        }
        composable("secondScreen") {
            SecondScreen(
                sharedViewModel = sharedViewModel,
                navigationToFirstScreen = { navController.navigate("firstScreen") },
                navigationToThirdScreen = { navController.navigate("thirdScreen") }
            )
        }
        composable("thirdScreen") {
            ThirdScreen(
                sharedViewModel = sharedViewModel,
                navigationToFirstScreen = { navController.navigate("firstScreen") },
                navigationToSecondScreen = { navController.navigate("secondScreen") },

            )
        }
    }
}
@Composable
fun NavigationButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(8.dp)
    ) {
        Text(text = text)
    }
}
