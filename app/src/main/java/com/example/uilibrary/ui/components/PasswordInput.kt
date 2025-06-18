package com.example.uilibrary.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.uilibrary.R
import com.example.uilibrary.ui.theme.AppTypography
import com.example.uilibrary.ui.theme.ContentOnNeutralLow

@Composable
fun PasswordInput(
    onValueChange: (String) -> Unit,
    value: String,
    modifier: Modifier,
    label: String,
    placeholder: String,
    labelTextStyle: TextStyle = AppTypography.labelM,
    requiredTextStyle: TextStyle = AppTypography.labelS,
    isRequired: Boolean = false,
    isError: Boolean = false
) {
    Column(modifier = modifier) {
        Row(modifier = Modifier.padding(bottom = 8.dp)) {
            Text(
                modifier = Modifier.padding(end = 8.dp),
                text = label,
                style = labelTextStyle,
                color = if (isError) MaterialTheme.colorScheme.error else Color.Unspecified
            )
            Text(
                modifier = Modifier,
                text = if (isRequired)
                    stringResource(R.string.textfield_required)
                else
                    stringResource(R.string.textfield_optional),
                style = requiredTextStyle,
                color = ContentOnNeutralLow
            )
        }

        OutlinedTextField(
            modifier = Modifier,
            onValueChange = { onValueChange(it) },
            value = value,
            placeholder = {
                Text(modifier = Modifier, style = labelTextStyle, text = placeholder)
            },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            isError = isError,
            shape = RoundedCornerShape(12.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            supportingText = {
                if (isError) {
                    Text(
                        modifier = Modifier,
                        text = stringResource(R.string.password_requirements),
                        style = requiredTextStyle,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
        )
    }
}

