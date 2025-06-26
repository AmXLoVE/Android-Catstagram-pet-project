package com.example.myapplication.presentation.story

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.presentation.base.model.Story
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
internal fun StoryScreen(
    onNavigate: () -> Unit,
    story: Story?
) {
    story ?: return

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.hsv(0f, 0f, 0.12f))
    ) {
        HeaderBlock(story = story)

        ImageBlock()

        ReactionBlock()
    }
}

@Composable
fun HeaderBlock(
    story: Story
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Image(
            painter = painterResource(story.icon),
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .padding(9.dp)
        )

        Text(
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically),
            text = story.name,
            color = Color.White,
        )
    }
}

@Composable
fun ImageBlock() {

}

@Composable
fun ReactionBlock() {

}

@Preview(heightDp = 800)
@Composable
private fun BaseScreenPreview() = MyApplicationTheme {
    StoryScreen(
        onNavigate = {},
        story = Story(
            name = "Alan",
        ),
    )
}