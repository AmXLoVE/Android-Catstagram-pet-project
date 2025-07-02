package com.example.myapplication.presentation.story

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.R
import com.example.myapplication.presentation.story.model.GetStoryImage
import com.example.myapplication.presentation.story.model.StoryScreenUiState
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
internal fun StoryScreen(
    onNavigate: () -> Unit,
    name: String,
    viewModel: StoryScreenViewModel = hiltViewModel(),
) {
    val state by remember {viewModel.uiStoryState}.collectAsState()

    Box(
        modifier = Modifier
            .background(Color.hsv(0f, 0f, 0.12f))
    ) {
        ImageBlock(state.image)

        Column(
            modifier = Modifier
                .zIndex(15f)
        ) {
            HeaderBlock(state)

            Spacer(
                modifier = Modifier
                    .weight(1f)
            )

            ReactionBlock()
        }
    }
}

@Composable
fun ImageBlock(imageRes: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(5f)
    ) {
        GetStoryImage(imageRes)
    }
}

@Composable
fun HeaderBlock(
    state: StoryScreenUiState
) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .zIndex(15f)
            .systemBarsPadding()
    ) {
        Image(
            painter = painterResource(state.icon),
            contentDescription = "",
            modifier = Modifier
                .size(70.dp)
                .padding(9.dp)
        )

        Text(
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically),
            text = state.name,
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
            .zIndex(15f)
            .systemBarsPadding()
    ) {
        OutlinedTextField(
            "",
            onValueChange = {interactionSource.value = it},
            modifier = Modifier
                .padding(8.dp),
            label = { Text(text = "Отправить сообщение...")},
            shape = RoundedCornerShape(percent = 100),
        )
    }
}

@Preview(heightDp = 800)
@Composable
private fun BaseScreenPreview() = MyApplicationTheme {
    StoryScreen(
        onNavigate = {},
        name = "",
    )
}