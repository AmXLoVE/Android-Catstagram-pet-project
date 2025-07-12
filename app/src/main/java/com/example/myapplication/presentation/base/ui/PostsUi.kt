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
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.request.Parameters
import coil.request.SuccessResult
import com.example.myapplication.R
import com.example.myapplication.domain.base.model.Post
import com.example.myapplication.presentation.base.vm.BaseScreenViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.collections.forEach

@Composable
fun PostsBlock(post: Post) {
    val context = LocalContext.current
    /*posts.forEach { post ->*/
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
            AsyncImage(
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                model = "data:image/jpeg;base64,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",
                /*rememberAsyncImagePainter(
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
                    .build(),*/
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
