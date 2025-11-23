package com.catstagram.android.feature.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.catstagram.android.data.core_data.story.StoryRepository
import com.catstagram.android.feature.basescreen.widget.TopBar

@Composable
public fun OneChatScreen(
    id: Int,
) {

    OneChatContent(id)
}

@Composable
internal fun OneChatContent(
    id: Int,
) {
    Column()
    {
        TopBar()


    }
}

@Composable
@Preview
private fun OneChatScreenContentPreview() {
    OneChatScreen(0)
}