package com.catstagram.android.feature.basescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.catstagram.android.domain.story.StoryPreview
import com.catstagram.android.feature.basescreen.model.BaseScreenUiModel
import com.catstagram.android.feature.basescreen.widget.ContentBlock
import com.catstagram.android.feature.basescreen.widget.TopBar
import com.catstagram.android.feature.basescreen.widget.LoadingBlock
import com.catstagram.android.feature.chat.ChatScreen
import com.example.catstagramdomain.R

@Composable
fun BaseScreen(
    onWatchAll: () -> Unit,
    onShowCurrentStory: (StoryPreview) -> Unit,
    onShowProfile: (Int) -> Unit,
    viewModel: BaseScreenViewModel = hiltViewModel(),
) {
    val state: BaseScreenUiModel by viewModel.uiBaseState.collectAsStateWithLifecycle()
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { 2 }
    )

    HorizontalPager(
        modifier = Modifier
            .fillMaxSize(),
        userScrollEnabled = true,
        state = pagerState,
    ) { page ->
        when (page) {
            0 -> BaseScreen(
                state = state,
                onWatchAll = onWatchAll,
                onShowCurrentStory = onShowCurrentStory,
                onShowProfile = onShowProfile,
            )

            1 -> ChatScreen()
        }
    }

}

@Composable
fun BaseScreen(
    state: BaseScreenUiModel,
    onWatchAll: () -> Unit,
    onShowCurrentStory: (StoryPreview) -> Unit,
    onShowProfile: (Int) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        TopBar()

        when (state) {
            is BaseScreenUiModel.Content -> ContentBlock(
                state = state,
                onWatchAll = onWatchAll,
                onShowCurrentStory = onShowCurrentStory,
                onShowProfile = onShowProfile,
            )

            is BaseScreenUiModel.Loading -> LoadingBlock()

            BaseScreenUiModel.Error -> {}
        }
    }
}
