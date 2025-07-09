package com.example.myapplication.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.example.myapplication.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen(
    id: Int,
    onNavigate: () -> Unit,
    /*viewModel: ProfileScreenViewModel = hiltViewModel(),*/
) {
    /*val profileState by remember { viewModel.uiProfileState }.collectAsState()
    viewModel.loadProfile(id)*/

    Column(
        modifier = Modifier
            .background(
                color = Color
                    .hsv(
                        0f,
                        0.05f,
                        0.08f
                    )
            )
            .fillMaxSize()
    ) {
        Header()

        ProfileState(onNavigate)

        ProfilePosts()
    }
}

@Composable
fun ProfilePosts() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(2.dp)
    ) {
        items(10,
            ) {
            Image(
                painter = painterResource(R.drawable.maxresdefault),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop,
            )
        }
    }
}

@Composable
fun DrawIcon(hasStory: Boolean,/* profileState: ProfileUiState,*/ onNavigate: () -> Unit) {
    if (hasStory) {
        Box(
            modifier = Modifier
                .size(110.dp)
                .padding(4.dp)
                .border(
                    2.dp, color = Color.hsv(
                        0f,
                        0.05f,
                        0.14f
                    ), shape = RoundedCornerShape(100)
                )
        ) {
            Image(
                painter = painterResource(R.drawable.app_icon), //TODO
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(100))
                    .clickable { onNavigate() },
            )
        }
    } else {
        Box(
            modifier = Modifier
                .size(110.dp)
                .padding(4.dp),
        ) {
            Image(
                painter = painterResource(R.drawable.app_icon), //TODO
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(6.dp)
                    .clip(shape = RoundedCornerShape(100)),
            )
        }
    }
}

@Composable
fun ColumnText(title: String, count: Int, modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            fontSize = 18.sp,
            maxLines = 1,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
        Text(
            text = "$count",
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            fontSize = 22.sp,
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )
    {
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = "",
            modifier = Modifier
                .size(70.dp)
        )
    }

    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(12.dp)
            .padding(4.dp)
            .background(
                Color.hsv(
                    0f,
                    0.05f,
                    0.12f
                ), shape = RoundedCornerShape(4.dp)
            )
    )
}

@Composable
fun ProfileState(onNavigate: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        DrawIcon(
            hasStory = true,
            /*profileState = profileState,*/
            onNavigate = onNavigate
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = "profileState.name",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
            )

            Row(
                modifier = Modifier
            ) {
                ColumnText(
                    "Публикаций",
                    99,
                    Modifier
                        .weight(1f)
                )

                ColumnText(
                    "Подписчиков",
                    99,
                    Modifier
                        .weight(1f)
                )

                ColumnText(
                    "Подписок",
                    99,
                    Modifier
                        .weight(1f)
                )
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(1, onNavigate = {})
}