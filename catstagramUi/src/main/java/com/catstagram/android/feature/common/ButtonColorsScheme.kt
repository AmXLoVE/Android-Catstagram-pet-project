package com.catstagram.android.feature.common

import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun buttonColorsScheme() : ButtonColors {
    return ButtonDefaults.buttonColors(
        containerColor = Color.White,
        contentColor = Color.Black,
        disabledContainerColor = Color.LightGray,
        disabledContentColor = Color.Gray,
    )
}