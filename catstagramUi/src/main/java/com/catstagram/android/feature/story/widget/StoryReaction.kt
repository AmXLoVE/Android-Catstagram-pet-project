package com.catstagram.android.feature.story.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
fun ReactionBlock() {
    val interactionSource = remember { mutableStateOf<String?>(null) }

    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .zIndex(1f)
            .systemBarsPadding()
    ) {
        OutlinedTextField(
            "",
            onValueChange = {
                interactionSource.value = it
                            },
            modifier = Modifier
                .padding(12.dp),
            label = {
                Text(
                    text = "Отправить сообщение..."
                )
                    },
            shape = RoundedCornerShape(percent = 100),
        )
    }
}