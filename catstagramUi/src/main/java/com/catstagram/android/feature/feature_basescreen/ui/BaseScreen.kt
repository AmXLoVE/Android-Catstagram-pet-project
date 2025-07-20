package com.catstagram.android.feature.feature_basescreen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.catstagram.android.domain.core_post.Post
import com.catstagram.android.domain.core_story.StoryPreview
import com.catstagram.android.domain.core_ui.components.base.HeaderBlock
import com.catstagram.android.domain.core_ui.components.post.PostsBlock
import com.catstagram.android.domain.core_ui.components.story.StoriesBlock
import com.catstagram.android.domain.core_ui.states.BaseScreenUiState
import com.catstagram.android.domain.core_user.userListPlaceHolder
import com.catstagram.android.feature.feature_basescreen.vm.BaseScreenViewModel
import com.example.catstagramdomain.R

@Composable
fun BaseScreen(
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

        if (state.isLoading) {
            DrawStoryPosts(
                onWatchAll,
                onShowCurrentStory,
                stories = listOf(
                    StoryPreview(user = userListPlaceHolder[0], R.drawable.usericon_placeholder),
                    StoryPreview(user = userListPlaceHolder[1], R.drawable.usericon_placeholder),
                    StoryPreview(user = userListPlaceHolder[2], R.drawable.usericon_placeholder),
                ),
                posts = listOf(
                    Post(
                        user = userListPlaceHolder[0],
                        image = "",
                        1920, 1080
                    ),
                    Post(
                        user = userListPlaceHolder[1],
                        image = "",
                        1920, 1080
                    )
                ),
                isLoading = state.isLoading,
            )
        } else {
            DrawStoryPosts(
                onWatchAll = onWatchAll,
                onShowCurrentStory = onShowCurrentStory,
                stories =  state.stories,
                posts =  state.posts,
                isLoading = state.isLoading,
            )
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

@Composable
fun DrawStoryPosts(
    onWatchAll: () -> Unit,
    onShowCurrentStory: (StoryPreview) -> Unit,
    stories: List<StoryPreview>,
    posts: List<Post>,
    isLoading: Boolean,
) {
    StoriesBlock(
        stories = stories,
        onWatchAll = onWatchAll,
        onShowCurrentStory = onShowCurrentStory,
        isLoading = isLoading
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        items(posts.size) { item ->
            PostsBlock(posts[item], isLoading)
        }
    }
}