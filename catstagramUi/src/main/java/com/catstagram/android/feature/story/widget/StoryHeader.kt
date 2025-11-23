package com.catstagram.android.feature.story.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.catstagram.android.feature.story.model.StoryScreenUiState
import com.example.catstagramdomain.R

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
        Box(
            modifier = Modifier
                .size(70.dp)
                .padding(9.dp)
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ) {
                    onShowProfile(state.user.id)
                }
                .clip(shape = RoundedCornerShape(100)),
        ) {
            Image(
                painter = painterResource(state.user.icon),
                contentDescription = "",
                contentScale = ContentScale.Crop,
            )
        }

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