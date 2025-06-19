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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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
    isError: Boolean = false,
    isEnabled: Boolean = true
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.padding(bottom = dimensionResource(R.dimen.xs)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier.padding(end = dimensionResource(R.dimen.xs)),
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
                Text(
                    modifier = Modifier,
                    style = labelTextStyle,
                    text = placeholder,
                    color = ContentOnNeutralLow
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            enabled = isEnabled,
            singleLine = true,
            isError = isError,
            shape = RoundedCornerShape(dimensionResource(R.dimen.radius_input)),
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

