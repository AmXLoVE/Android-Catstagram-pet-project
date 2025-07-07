package com.example.myapplication.presentation.story

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.R
import com.example.myapplication.domain.user.model.User
import com.example.myapplication.presentation.story.model.GetStoryImage
import com.example.myapplication.presentation.story.model.StoryScreenUiState
import com.example.myapplication.presentation.story.vm.StoryScreenViewModel
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
internal fun StoryScreen(
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

@Composable
fun ImageBlock(
    imageRes: Int,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(0.1f)
    ) {
        GetStoryImage(imageRes)
    }
}

@Composable
fun HeaderBlock(
    state: StoryScreenUiState,
    onShowProfile: (Int) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .zIndex(1f)
            .systemBarsPadding()
    ) {
        Image(
            painter = painterResource(state.user.icon),
            contentDescription = "",
            modifier = Modifier
                .size(70.dp)
                .padding(9.dp)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ) {
                    onShowProfile(state.user.id)
                }
        )

        Text(
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically),
            text = state.user.name,
            color = Color.White,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(R.drawable.dots3_2),
            contentDescription = "",
            modifier = Modifier
                .size(50.dp)
                .padding(9.dp)
                .align(alignment = Alignment.CenterVertically),
        )
    }
}

@Composable
fun ReactionBlock() {
    val interactionSource = remember { mutableStateOf<String?>(null) }

    Row(
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .fillMaxWidth()
            .zIndex(1f)
            .systemBarsPadding()
    ) {
        OutlinedTextField(
            "",
            onValueChange = { interactionSource.value = it },
            modifier = Modifier
                .padding(8.dp),
            label = { Text(text = "Отправить сообщение...") },
            shape = RoundedCornerShape(percent = 100),
        )
    }
}

/**
 * Тап по правой части экрана - свайп вправо
 */
@Composable
fun BoxForSwipeRight(pagerState: PagerState, coroutineScope: CoroutineScope) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(
                                (pagerState.currentPage + 1)
                                    .coerceAtLeast(0)
                            )
                        }
                    })
            }
            .padding(start = LocalConfiguration.current.screenWidthDp.dp / 2)
    )
}

/**
 * Тап по левой части экрана - свайп влево
 */
@Composable
fun BoxForSwipeLeft(pagerState: PagerState, coroutineScope: CoroutineScope) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.5f)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(
                                (pagerState.currentPage - 1)
                                    .coerceAtLeast(0)
                            )
                        }
                    })
            }
    )
}

@Preview(heightDp = 800)
@Composable
private fun BaseScreenPreview() = MyApplicationTheme {
    StoryScreen(
        id = 1,
        onShowProfile = {},
    )
}