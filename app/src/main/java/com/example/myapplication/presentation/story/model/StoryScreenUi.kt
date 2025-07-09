package com.example.myapplication.presentation.story.model

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.myapplication.domain.story.model.Story

@Composable
fun GetStoryImage(imageRes: Int){
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageRes)
            .crossfade(true)
            .build(),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Fit
    )
}