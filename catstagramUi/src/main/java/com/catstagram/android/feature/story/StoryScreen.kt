package com.catstagram.android.feature.story

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.catstagram.android.feature.story.widget.BoxForSwipeLeft
import com.catstagram.android.feature.story.widget.BoxForSwipeRight
import com.catstagram.android.feature.story.widget.HeaderBlock
import com.catstagram.android.feature.story.widget.ImageBlock
import com.catstagram.android.feature.story.widget.ReactionBlock

@Composable
fun StoryScreen(
    id: Int,
    onShowProfile: (Int) -> Unit,
    viewModel: StoryScreenViewModel = hiltViewModel(),
) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        initialPage = id,
        pageCount = { viewModel.countAvailableStories() }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxSize(),
            userScrollEnabled = true,
            state = pagerState,
        ) { page ->
            ShowStory(page, onShowProfile, viewModel)

        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp)
        ) {
            BoxForSwipeLeft(pagerState, coroutineScope)
            BoxForSwipeRight(pagerState, coroutineScope)
        }
    }
}

@Composable
fun ShowStory(
    page: Int,
    onShowProfile: (Int) -> Unit,
    viewModel: StoryScreenViewModel,
) {
    val storyState = viewModel.loadStory(page)

    Box(
        modifier = Modifier
            .background(Color.hsv(0f, 0f, 0.12f))
    ) {
        Column(
            modifier = Modifier
                .zIndex(1f)
        ) {
            HeaderBlock(storyState, onShowProfile)

            Spacer(
                modifier = Modifier
                    .weight(1f)
            )

            ReactionBlock()
        }

        ImageBlock(storyState.image)

    }
}





