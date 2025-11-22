package com.catstagram.android.feature.basescreen.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.catstagram.android.domain.post.Post
import com.catstagram.android.domain.story.StoryPreview
import com.catstagram.android.feature.basescreen.model.BaseScreenUiModel
import com.catstagram.android.feature.common.shimmerLoading
import com.example.catstagramdomain.R
import kotlin.collections.forEach

@Composable
fun ContentBlock(
    state: BaseScreenUiModel.Content,
    onWatchAll: () -> Unit,
    onShowCurrentStory: (StoryPreview) -> Unit,
    onShowProfile: (Int) -> Unit,
) {
    StoriesBlock(
        stories = state.stories,
        onWatchAll = onWatchAll,
        onShowCurrentStory = onShowCurrentStory,
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        items(state.posts) { post ->
            PostsBlock(
                post = post,
                onShowProfile = onShowProfile,
            )
        }
    }
}

@Composable
private fun StoriesBlock(
    stories: List<StoryPreview>,
    onWatchAll: () -> Unit,
    onShowCurrentStory: (StoryPreview) -> Unit,
) {
    TopStoriesBlock(onWatchAll = onWatchAll)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, top = 0.dp, end = 12.dp, bottom = 6.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        DrawStories(
            stories = stories,
            onShowCurrentStory = onShowCurrentStory,
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
private fun DrawStories(
    stories: List<StoryPreview>,
    onShowCurrentStory: (StoryPreview) -> Unit,
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
                            .align(alignment = Alignment.TopCenter),
                        text = story.user.name,
                    )
                }
            }
        }
    }
}

@Composable
private fun PostsBlock(
    post: Post,
    onShowProfile: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .padding(4.dp)
                    .clip(shape = CircleShape)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                    ) {
                        onShowProfile(post.user.id)
                    },
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(alignment = Alignment.Center),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(post.user.icon),
                    contentDescription = "",
                )
            }

            Column {
                Row {
                    Text(text = post.user.name)
                }
                Row {
                    Text(text = "Posted in ${post.time}", fontSize = 12.sp)
                }
            }
        }

        AsyncImage(
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(
                    run {
                        if (post.width > 0 && post.height > 0) {
                            (post.width.toFloat() / post.height.toFloat()).coerceIn(0.1f, 10f)
                        } else 1f
                    }
                ),
            model = post.image,
            contentDescription = "...",
        )


        PostBottomBlock(
            likeCount = post.likeCount,
            commCount = post.commCount,
            repCount = post.repCount,
        )
    }

    Spacer(
        modifier = Modifier
            .height(2.dp)
            .background(
                color = Color.hsv(206f, 0.1f, 0.9f),
                shape = RoundedCornerShape(percent = 100)
            )
            .fillMaxWidth()
    )
}