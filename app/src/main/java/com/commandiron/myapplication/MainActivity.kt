package com.commandiron.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.commandiron.myapplication.ui.theme.MyApplicationTheme
import com.commandiron.outlined_drop_down_menu.OutlinedDropDownMenu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    val items by remember { mutableStateOf(listOf("item 1", "item 2", "item 3")) }
                    OutlinedDropDownMenu(
                        label = "label",
                        items = items,
                        unit = " unit",
                        onSelect = {
                            //SelectedItem
                        }
                    )
                }
            }
        }
    }
}

