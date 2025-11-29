package com.catstagram.android.feature.chat.widget

import androidx.compose.runtime.Composable
import com.catstagram.android.feature.basescreen.widget.BaseScreenError

@Composable
internal fun ChatScreenError(
    updateContent: () -> Unit,
) {
    BaseScreenError(
        updateContent = updateContent,
    )
}