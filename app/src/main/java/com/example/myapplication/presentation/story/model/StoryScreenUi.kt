package com.example.myapplication.presentation.story.model

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.myapplication.domain.story.model.Story

@Composable
fun GetStoryImage(story: Story){
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(story.image)
            .crossfade(true)
            .build(),
        contentDescription = "",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Fit
    )
}