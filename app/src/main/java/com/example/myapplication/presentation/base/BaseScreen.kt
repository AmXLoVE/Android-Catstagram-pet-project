package com.example.myapplication.presentation.base

import android.util.Log
import com.example.myapplication.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.domain.story.model.*
import com.example.myapplication.domain.user.model.User
import com.example.myapplication.presentation.base.vm.BaseScreenViewModel
import com.example.myapplication.presentation.base.ui.*
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
internal fun BaseScreen(
    onWatchAll: () -> Unit,
    onShowCurrentStory: (StoryPreview) -> Unit,
    onShowProfile: (Int) -> Unit,
    viewModel: BaseScreenViewModel = hiltViewModel(),
) {
    val state by viewModel.uiBaseState.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()
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
            0 -> DrawBaseScreen(
                viewModel = viewModel,
                scrollState = scrollState,
                state = state,
                onWatchAll = onWatchAll,
                onShowCurrentStory = onShowCurrentStory,
            )

            1 -> DrawChat()
        }
    }

}

@Composable
fun DrawBaseScreen(
    viewModel: BaseScreenViewModel,
    scrollState: ScrollState,
    state: BaseScreenUiState,
    onWatchAll: () -> Unit,
    onShowCurrentStory: (StoryPreview) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        HeaderBlock()

        StoriesBlock(
            viewModel = viewModel,
            stories = state.stories,
            onWatchAll = onWatchAll,
            onShowCurrentStory = onShowCurrentStory,
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        items(state.posts.count()) { item ->
            PostsBlock(state.posts[item])
        }
    }
}

@Composable
fun DrawChat() {
    Image(
        painter = painterResource(R.drawable.maxresdefault),
        contentDescription = "",
    )
}

@Preview(heightDp = 800)
@Composable
private fun BaseScreenPreview() = MyApplicationTheme {
    BaseScreen(
        onWatchAll = {},
        onShowCurrentStory = {},
        onShowProfile = {},
    )
}