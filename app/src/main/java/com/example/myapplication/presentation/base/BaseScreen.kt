package com.example.myapplication.presentation.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.domain.base.model.*
import com.example.myapplication.domain.story.model.*
import com.example.myapplication.presentation.base.Ui.*
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
internal fun BaseScreen(
    onWatchAll: () -> Unit,
    onShowCurrentStory: (StoryPreview) -> Unit,
    viewModel: BaseScreenViewModel = hiltViewModel(),
) {
    val state by remember {viewModel.uiState}.collectAsState()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .verticalScroll(scrollState)
    ) {
        HeaderBlock()

        StoriesBlock(
            stories = state.stories,
            onWatchAll = onWatchAll,
            onShowCurrentStory = onShowCurrentStory,
        )

        PostsBlock(postList)
    }
}

@Preview(heightDp = 800)
@Composable
private fun BaseScreenPreview() = MyApplicationTheme {
    BaseScreen(
        onWatchAll = {},
        onShowCurrentStory = {},
        hiltViewModel<BaseScreenViewModel>()
    )
}