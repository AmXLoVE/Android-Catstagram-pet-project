package com.example.myapplication.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.myapplication.data.story.StoryRepository
import com.example.myapplication.data.user.UserRepository
import com.example.myapplication.presentation.profile.ui.ProfileUiState
import com.example.myapplication.presentation.profile.vm.ProfileScreenViewModel

@Composable
fun ProfileScreen(
    id: Int,
    onNavigate: () -> Unit,
    viewModel: ProfileScreenViewModel = hiltViewModel(),
) {
    val profileState by remember {viewModel.uiProfileState}.collectAsState()
    viewModel.loadProfile(id)

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

        ProfileState(profileState, viewModel, onNavigate)

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ){
            //TODO pages implement (HorizontalPager)
            ProfilePosts(viewModel)
        }
    }
}

@Composable
fun ProfilePosts(viewModel: ProfileScreenViewModel) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(viewModel.getUsersPostCount(),
            ) {
            AsyncImage(
                model = viewModel.getUserPostFromIndex(it).image,
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
fun DrawIcon(hasStory: Boolean, profileState: ProfileUiState, onNavigate: () -> Unit) {
    if (hasStory) {
        Box(
            modifier = Modifier
                .size(90.dp)
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
                painter = painterResource(profileState.icon),
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
                painter = painterResource(profileState.icon),
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
            .padding(4.dp)
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
            .padding(12.dp)
    )
    {
        Image(
            painter = painterResource(R.drawable.app_icon),
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
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
fun ProfileState(profileState: ProfileUiState, viewModel: ProfileScreenViewModel, onNavigate: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        DrawIcon(
            hasStory = true,
            profileState = profileState,
            onNavigate = onNavigate
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(4.dp),
                text = profileState.name,
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Normal,
            )

            Row(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                ColumnText(
                    title = "Публикаций",
                    count = viewModel.getUsersPostCount(),
                    modifier = Modifier
                        .weight(1f)
                )

                ColumnText(
                    title = "Подписчиков",
                    count = viewModel.getUserSubscriberCount(),
                    modifier = Modifier
                        .weight(1f)
                )

                ColumnText(
                    title = "Подписок",
                    count = viewModel.getUserSubscriptionCount(),
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(
        1,
        onNavigate = {},
    )
}