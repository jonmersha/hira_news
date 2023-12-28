package com.hira.news.custom_component
// CustomTextField.kt

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label = label,
        placeholder = placeholder,
        textStyle = LocalTextStyle.current,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,

//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedBorderColor = TextFieldDefaults.outlinedTextFieldColors().focusedLabelColor,
//            unfocusedBorderColor = TextFieldDefaults.outlinedTextFieldColors().unfocusedLabelColor
//        )
    )
}
