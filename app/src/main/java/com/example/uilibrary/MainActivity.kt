package com.example.uilibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.uilibrary.ui.components.PasswordInput
import com.example.uilibrary.ui.theme.UiLibraryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UiLibraryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.SpaceAround
                    ) {
                        val viewModel by viewModels<MainViewModel>()
                        val password by viewModel.password.collectAsStateWithLifecycle()
                        val isPasswordValid by viewModel.isPasswordValid.collectAsStateWithLifecycle()
                        PasswordInput(
                            onValueChange = { viewModel.onPasswordChange(it) },
                            value = password,
                            modifier = Modifier.padding(32.dp),
                            label = stringResource(R.string.password_label),
                            placeholder = stringResource(R.string.password_placeholder),
                            isError = !isPasswordValid
                        )
                    }
                }
            }
        }
    }
}