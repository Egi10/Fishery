package com.buaja.home.ui.new_item.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buaja.ui_theme.Purple500


/**
 * @created 07/03/22 19.08
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun FisheryOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                fontSize = 12.sp,
                color = Purple500
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}