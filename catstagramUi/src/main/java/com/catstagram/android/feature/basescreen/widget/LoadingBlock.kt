package com.catstagram.android.feature.basescreen.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.catstagram.android.feature.common.shimmerLoading

@Composable
fun LoadingBlock() {
    Column {
        StoriesBlock()

        SpacerHeight(12.dp)

        repeat(2) {
            Column {
                TopBlock()

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .shimmerLoading(),
                )

                SpacerHeight(12.dp)

                Box(
                    modifier = Modifier
                        .padding(start = 12.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .width(200.dp)
                        .height(30.dp)
                        .shimmerLoading(),
                )
            }
        }
    }
}

@Composable
private fun StoriesBlock() {
    TopStoriesBlock(onWatchAll = {})

    Row(modifier = Modifier.padding(start = 12.dp)) {
        repeat(6) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                        .shimmerLoading(),
                )

                SpacerHeight(4.dp)

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(2.dp))
                        .height(5.dp)
                        .width(30.dp)
                        .shimmerLoading(),
                )
            }

            SpacerWidth(8.dp)
        }
    }
}

@Composable
private fun TopBlock() {
    Row(
        modifier = Modifier.padding(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(24.dp)
                .shimmerLoading(),
        )

        SpacerWidth(12.dp)

        Column {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .height(5.dp)
                    .width(40.dp)
                    .shimmerLoading(),
            )

            SpacerHeight(4.dp)

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .height(5.dp)
                    .width(100.dp)
                    .shimmerLoading(),
            )
        }
    }
}

@Composable
fun RowScope.SpacerWidth(dp: Dp) = Spacer(modifier = Modifier.width(dp))

@Composable
fun ColumnScope.SpacerHeight(dp: Dp) = Spacer(modifier = Modifier.height(dp))
