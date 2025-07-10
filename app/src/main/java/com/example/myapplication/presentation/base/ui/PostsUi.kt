package com.example.myapplication.presentation.base.ui

import android.util.Log
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.Parameters
import coil.request.SuccessResult
import com.example.myapplication.R
import com.example.myapplication.domain.base.model.Post
import kotlin.collections.forEach

@Composable
fun PostsBlock(posts: List<Post>) {
    val context = LocalContext.current
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
                    Icon(
                        modifier = Modifier
                            .size(45.dp)
                            .padding(4.dp),
                        painter = painterResource(post.user.icon),
                        contentDescription = ""
                    )

                    Column {
                        Row {
                            Text(text = post.user.name)
                        }
                        Row {
                            Text(text = "Posted in ${post.time}", fontSize = 12.sp)
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    Log.i("asdfasdf", "${post.image}")
                    Image(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize(),
                        painter = rememberAsyncImagePainter(
                            ImageRequest
                                .Builder(context)
                                .okHttpClient {
                                    OkHttpClient.Builder()
                                        .connectTimeout(30, TimeUnit.SECONDS)
                                        .readTimeout(30, TimeUnit.SECONDS)
                                        .build()
                                }
                                .parameters(Parameters())
                                .listener(object : ImageRequest.Listener {
                                    override fun onCancel(request: ImageRequest) {
                                        super.onCancel(request)
                                        Log.i("asdfasdf", "cancel")
                                    }

                                    override fun onError(
                                        request: ImageRequest,
                                        result: ErrorResult
                                    ) {
                                        super.onError(request, result)

                                        Log.i("asdfasdf", "${result.throwable.message}")
                                    }

                                    override fun onStart(request: ImageRequest) {
                                        super.onStart(request)
                                        Log.i("asdfasdf", "start")
                                    }

                                    override fun onSuccess(
                                        request: ImageRequest,
                                        result: SuccessResult
                                    ) {
                                        super.onSuccess(request, result)
                                        Log.i("asdfasdf", "success")
                                    }
                                })
                                .data(post.image)
                                .size(20, 20)
                                .build(),

                        ),
                        contentDescription = "...",
                    )
                }

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
    }
}