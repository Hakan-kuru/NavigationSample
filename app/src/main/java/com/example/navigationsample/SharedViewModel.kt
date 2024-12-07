package com.example.navigationsample

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class SharedViewModel: ViewModel(){
    var name by mutableStateOf("")
        private set
    fun updateName(newName: String){
        name = newName
    }
}