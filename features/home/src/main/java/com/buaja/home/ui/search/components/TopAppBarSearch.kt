package com.buaja.home.ui.search.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp
import com.buaja.home.R
import com.buaja.ui_theme.Purple500


/**
 * @created 07/03/22 08.23
 * @author Julsapargi Nursam
 * @project Fishery
 **/

@Composable
fun TopAppBarSearch(
    onDismissClick: () -> Unit,
    value: String,
    onValueChange: (String) -> Unit,
    onSearchClick: (String) -> Unit
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(),
        backgroundColor = Color.White,
        navigationIcon = {
            IconButton(
                onClick = onDismissClick,
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                        contentDescription = null
                    )
                }
            )
        },
        title = {
            BasicTextField(
                value = value,
                onValueChange = {
                    onValueChange.invoke(it)
                },
                textStyle = TextStyle(
                    fontSize = 16.sp
                ),
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearchClick.invoke(value)
                    }
                ),
                cursorBrush = SolidColor(Purple500)
            ) { innerTextField ->
                if (value.isEmpty()) {
                    Text(
                        text = stringResource(R.string.search_commudity),
                        fontSize = 16.sp,
                        color = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium)
                    )
                }
                innerTextField()
            }
        }
    )
}