package com.example.myapplication.presentation.base.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.domain.base.model.Post
import com.example.myapplication.presentation.base.vm.BaseScreenViewModel
import kotlin.collections.forEach

@Composable
fun PostsBlock(posts: List<Post>, viewModel: BaseScreenViewModel) {
    Column {
        posts.forEach { post ->
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
                            .clip(shape = RoundedCornerShape(100))
                    ) {
                        Image(
                            painter = painterResource(post.user.icon),
                            contentDescription = "",
                            contentScale = ContentScale.Crop,
                        )
                    }

                    Column {
                        Row {
                            Text(text = post.user.name)
                        }
                        Row {
                            Text(
                                text = "Posted in ${viewModel.getPostTime(post)}",
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                Box {
                    Image(
                        painter = painterResource(post.image),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize(),
                        contentDescription = "...",
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(6.dp, 12.dp)
                ) {
                    Image(
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

                    Image(
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

                    Image(
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
    }
}