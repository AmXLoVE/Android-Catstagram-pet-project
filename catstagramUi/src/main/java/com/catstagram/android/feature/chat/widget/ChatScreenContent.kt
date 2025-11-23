package com.catstagram.android.feature.chat.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.catstagram.android.feature.basescreen.widget.SpacerHeight
import com.catstagram.android.feature.basescreen.widget.SpacerWidth
import com.catstagram.android.feature.chat.model.ChatScreenUiItem
import com.catstagram.android.feature.chat.model.ChatScreenUiState
import com.example.catstagramui.R

@Composable
internal fun ChatScreenContent(
    state: ChatScreenUiState.Content,
    onChatClick: (Int) -> Unit,
) {
    LazyColumn() {
        items(state.chats) { item ->
            ChatItem(
                item = item,
                onChatClick = { onChatClick(item.id) },
            )
        }
    }
}

@Composable
private fun ChatItem(
    item: ChatScreenUiItem,
    onChatClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 6.dp)
            .height(60.dp)
            .clickable(onClick = onChatClick),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            modifier = Modifier
                .clip(CircleShape)
                .size(60.dp),
            placeholder = painterResource(R.drawable.maxresdefault),
            contentScale = ContentScale.Crop,
            model = item.avatarRes,

            contentDescription = "...",
        )

        SpacerWidth(4.dp)

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = item.name,
                color = defineColor(item = item),
                fontWeight = defineFontWeight(item = item),
                fontSize = 18.sp,
            )
            SpacerHeight(4.dp)

            Row {
                Text(
                    modifier = Modifier.weight(weight = 1f, fill = false),
                    text = item.lastMessage,
                    color = defineColor(item = item),
                    fontWeight = defineFontWeight(item = item),
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                SpacerWidth(4.dp)

                Text(
                    text = item.date,
                    color = Color.Gray,
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }

        SpacerWidth(4.dp)

        Icon(
            painter = painterResource(R.drawable.photo_icon),
            contentDescription = "",
        )
    }
}

private fun defineColor(item: ChatScreenUiItem): Color {
    return when {
        item.hasHistory -> Color.Blue

        !item.isRead -> Color.Black

        else -> Color.Gray
    }
}

private fun defineFontWeight(item: ChatScreenUiItem): FontWeight {
    return if (item.hasHistory || !item.isRead) {
        FontWeight.Bold
    } else {
        FontWeight.Normal
    }
}

@Composable
@Preview
private fun ChatScreenContentPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
    ) {
        ChatScreenContent(
            state = ChatScreenUiState.Content(
                chats = List(6) { index ->
                    ChatScreenUiItem(
                        id = 0,
                        avatarRes = R.drawable.photo_icon,
                        name = "name",
                        lastMessage = "some message",
                        date = "2m ago",
                        isRead = index == 3,
                        hasHistory = index == 2,
                    )
                },
            ),
            onChatClick = {},
        )
    }
}
