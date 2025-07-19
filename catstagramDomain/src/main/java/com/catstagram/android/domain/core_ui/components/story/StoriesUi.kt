package com.catstagram.android.domain.core_ui.components.story

import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.catstagram.android.domain.core_ui.components.animation.shimmerLoading
import com.example.catstagram.R
import com.catstagram.app.domain.story.model.StoryPreview
import com.catstagram.app.presentation.base.vm.BaseScreenViewModel

@Composable
fun StoriesBlock(
    viewModel: BaseScreenViewModel,
    stories: List<StoryPreview>,
    onWatchAll: () -> Unit,
    onShowCurrentStory: (StoryPreview) -> Unit,
    isLoading: Boolean,
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
        DrawStories(
            stories = stories,
            onShowCurrentStory = onShowCurrentStory,
            isLoading = isLoading
        )
    }

    Spacer(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(3.dp)
            .background(color = Color.hsv(206f, 0.03f, 0.9f))
            .fillMaxWidth()
    )
}

@Composable
fun DrawStories(
    stories: List<StoryPreview>,
    onShowCurrentStory: (StoryPreview) -> Unit,
    isLoading: Boolean,
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
                Box(
                    modifier = Modifier
                        .size(75.dp)
                        .clip(shape = RoundedCornerShape(100))
                        .shimmerLoading(isLoading = isLoading),
                ) {
                    Image(
                        modifier = Modifier
                            .align(alignment = Alignment.Center)
                            .fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        painter = painterResource(story.user.icon),
                        contentDescription = "",
                    )
                }
                Box(modifier = Modifier.fillMaxSize()) {
                    Text(
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(6.dp, 0.dp)
                            .align(alignment = Alignment.TopCenter)
                            .shimmerLoading(isLoading = isLoading),
                        text = story.user.name,
                    )
                }
            }
        }
    }
}