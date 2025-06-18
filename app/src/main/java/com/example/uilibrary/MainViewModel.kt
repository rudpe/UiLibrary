package com.example.uilibrary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uilibrary.utils.PasswordUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    val isPasswordValid: StateFlow<Boolean> = password.map {
        if (it.isNotBlank()) {
            PasswordUtil.isPasswordValid(it)
        } else {
            true
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)

    fun onPasswordChange(value: String) {
        _password.update { value }
    }
}