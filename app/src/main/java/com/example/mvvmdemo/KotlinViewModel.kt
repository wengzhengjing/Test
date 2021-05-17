package com.example.mvvmdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KotlinViewModel : ViewModel() {
    fun loadData() {
       viewModelScope.launch(Dispatchers.IO) {
         
       }
    }
}