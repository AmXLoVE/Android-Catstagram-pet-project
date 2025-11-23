package com.catstagram.android.feature.story.widget

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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