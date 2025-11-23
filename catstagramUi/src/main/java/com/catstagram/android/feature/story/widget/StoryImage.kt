package com.catstagram.android.feature.story.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex

@Composable
fun ImageBlock(
    imageRes: Int,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(0.1f)
    ) {
        GetStoryImage(imageRes)
    }
}