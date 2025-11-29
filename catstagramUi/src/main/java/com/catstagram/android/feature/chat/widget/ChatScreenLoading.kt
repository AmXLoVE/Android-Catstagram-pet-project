package com.catstagram.android.feature.chat.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.catstagram.android.feature.basescreen.widget.SpacerHeight
import com.catstagram.android.feature.basescreen.widget.SpacerWidth
import com.catstagram.android.feature.chat.model.ChatScreenUiItem
import com.catstagram.android.feature.chat.model.ChatScreenUiState
import com.catstagram.android.feature.common.shimmerLoading
import com.example.catstagramui.R

@Composable
internal fun ChatScreenLoading() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
    ) {
        repeat(times = 6) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Box(
                    modifier = Modifier
                        .size(70.dp)
                        .padding(4.dp)
                        .clip(CircleShape)
                        .shimmerLoading(),

                )

                SpacerWidth(8.dp)

                Column {
                    Row(
                        modifier = Modifier
                            .size(90.dp, 16.dp)
                            .clip(RoundedCornerShape(15))
                            .shimmerLoading()
                    ) {}

                    SpacerHeight(12.dp)

                    Row(
                        modifier = Modifier
                            .size(140.dp, 16.dp)
                            .clip(RoundedCornerShape(15))
                            .shimmerLoading()
                    ) {}
                }
            }
        }
    }
}

@Composable
@Preview
private fun ChatScreenLoadingPreview() {
    ChatScreenLoading()
}