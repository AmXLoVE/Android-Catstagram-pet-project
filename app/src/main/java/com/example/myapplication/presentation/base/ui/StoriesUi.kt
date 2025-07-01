package com.example.myapplication.presentation.base.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.domain.story.model.StoryPreview
import kotlin.collections.forEach

@Composable
fun StoriesBlock(
    stories: List<StoryPreview>,
    onWatchAll: () -> Unit,
    onShowCurrentStory: (StoryPreview) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Stories", fontSize = 20.sp)

        Spacer(modifier = Modifier.weight(1f))

        Button(
            modifier = Modifier,
            onClick = onWatchAll,
            shape = RoundedCornerShape(30.dp),
            colors = ButtonColors(
                contentColor = Color.Black,
                containerColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.White
            ),
        ) {
            Icon(
                painter = painterResource(R.drawable.play_icon),
                contentDescription = "",
            )
            Text(
                text = "Watch All",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, top = 0.dp, end = 12.dp, bottom = 6.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        stories.forEach { story ->
            Button(
                modifier = Modifier
                    .size(75.dp, 110.dp)
                    .padding(4.dp),
                onClick = { onShowCurrentStory(story) },
                shape = RoundedCornerShape(15.dp),
                colors = ButtonColors(
                    contentColor = Color.Black,
                    containerColor = Color.White,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.White
                ),
                contentPadding = PaddingValues(0.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Icon(
                        modifier = Modifier.size(75.dp),
                        painter = painterResource(R.drawable.photo_icon),
                        contentDescription = "",
                    )
                    Box(modifier = Modifier.fillMaxSize()) {
                        Text(
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .padding(6.dp, 0.dp)
                                .align(alignment = Alignment.TopCenter),
                            text = story.name,
                        )
                    }
                }
            }
        }
    }

    Spacer(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(3.dp)
            .background(color = Color.hsv(206f, 0.03f, 0.9f))
            .fillMaxWidth()
    )
}