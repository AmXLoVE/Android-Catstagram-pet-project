package com.example.myapplication.presentation.base.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.myapplication.R
import com.example.myapplication.domain.base.model.Post

@Composable
fun PostsBlock(
    post: Post,
    isLoading: Boolean,
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
                    .clip(shape = CircleShape),
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .align(alignment = Alignment.Center)
                        .shimmerLoading(isLoading = isLoading),
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
                .aspectRatio(post.width.toFloat() / post.height.toFloat())
                .shimmerLoading(isLoading = isLoading),
            model = post.image,
            contentDescription = "...",
        )


        Row(
            modifier = Modifier
                .padding(6.dp, 12.dp)
        ) {
            Icon(
                modifier = Modifier.size(40.dp),
                painter = painterResource(R.drawable.play_icon),
                contentDescription = ""
            )
            Text(
                text = post.likeCount.toString(),
                fontSize = 22.sp,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )

            Icon(
                modifier = Modifier.size(40.dp),
                painter = painterResource(R.drawable.play_icon),
                contentDescription = ""
            )
            Text(
                text = post.commCount.toString(),
                fontSize = 22.sp,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )

            Icon(
                modifier = Modifier.size(40.dp),
                painter = painterResource(R.drawable.play_icon),
                contentDescription = ""
            )
            Text(
                text = post.repCount.toString(),
                fontSize = 22.sp,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.align(alignment = Alignment.CenterVertically)
            )
        }
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