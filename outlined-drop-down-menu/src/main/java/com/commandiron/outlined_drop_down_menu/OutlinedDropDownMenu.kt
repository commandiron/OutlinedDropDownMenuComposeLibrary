package com.commandiron.outlined_drop_down_menu
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText

@Composable
fun OutlinedDropDownMenu(
    modifier: Modifier = Modifier,
    dropDownMenuModifier: Modifier = Modifier,
    label: String,
    items: List<String>?,
    unit: String,
    onSelect: (String) -> Unit
) {
    var selectedItem by remember { mutableStateOf("") }
    var isExpanded by remember { mutableStateOf(false) }
    val focusRequester = FocusRequester()
    val focusManager = LocalFocusManager.current
    Column(modifier = modifier) {
        OutlinedTextField(
            value = selectedItem,
            onValueChange = {},
            modifier = Modifier
                .focusRequester(focusRequester)
                .onFocusChanged {
                    if (it.hasFocus) {
                        isExpanded = !isExpanded
                    }
                },
            readOnly = true,
            label = {
                Text(
                    text = label,
                )
            },
            trailingIcon = {
                Text(
                    text = "Clear",
                    modifier = Modifier.clickable { selectedItem = "" },
                    color = LocalContentColor.current.copy(alpha = 0.5f),
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                autoCorrect = false
            ),
            visualTransformation = {
                if(selectedItem.isNotEmpty() && unit.isNotEmpty()){
                    TransformedText(AnnotatedString(it.text + unit), OffsetMapping.Identity)
                }else{
                    TransformedText(it, OffsetMapping.Identity)
                }
            }
        )
        CustomDropDownMenu(
            modifier = dropDownMenuModifier,
            isExpanded = isExpanded,
            onDismissRequest = {
                focusManager.clearFocus()
                isExpanded = !isExpanded
            },
            dropDownItems = items,
            onSelect = {
                selectedItem = items!![it]
                onSelect(selectedItem)
                focusManager.clearFocus()
                isExpanded = !isExpanded
            },
            unit = unit
        )
    }
}

@Composable
fun CustomDropDownMenu(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
    onDismissRequest:(Int?) -> Unit,
    dropDownItems: List<String>?,
    onSelect:(Int) -> Unit,
    unit: String,
) {
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    DropdownMenu(
        expanded = isExpanded,
        onDismissRequest = {
            onDismissRequest(selectedIndex)
        },
        modifier = modifier
    ) {
        dropDownItems?.forEachIndexed{ index, title->
            var enabled by remember { mutableStateOf(false)}
            enabled = index == selectedIndex
            DropdownMenuItem(
                text = {
                    Row(
                        modifier = Modifier
                    ) {
                        Text(text = title)
                    }
                },
                onClick = {
                    enabled = !enabled
                    selectedIndex = index
                    selectedIndex?.let {
                        onSelect(it)
                    }
                },
                trailingIcon = {
                    Text(text = unit)
                },
                enabled = !enabled
            )
        }
    }
}